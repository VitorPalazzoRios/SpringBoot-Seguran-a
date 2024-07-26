package com.example.projetoseguranca.domain.service;

import com.example.projetoseguranca.domain.entity.Grupo;
import com.example.projetoseguranca.domain.entity.GrupoUsuario;
import com.example.projetoseguranca.domain.entity.Usuario;
import com.example.projetoseguranca.domain.repository.GrupoRepository;
import com.example.projetoseguranca.domain.repository.GrupoUsuarioRepository;
import com.example.projetoseguranca.domain.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final GrupoRepository grupoRepository;
    private final GrupoUsuarioRepository grupoUsuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario salvar(Usuario usuario, List<String> grupos) {
        String SenhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(SenhaCriptografada);
        usuarioRepository.save(usuario);

        List<GrupoUsuario> listaUsuarioGrupo = grupos.stream().map(nomeGrupo -> {
            Optional<Grupo> PossivelGrupo = grupoRepository.findByNome(nomeGrupo);
            if (PossivelGrupo.isPresent()) {
                Grupo grupo = PossivelGrupo.get();
                return new GrupoUsuario(usuario, grupo);
            }
            return null;
        }).filter(grupo -> grupo != null).collect(Collectors.toList());
        grupoUsuarioRepository.saveAll(listaUsuarioGrupo);
        return usuario;

    }

    public Usuario obterUsuarioComPermissoes(String login){
        Optional<Usuario> usuarioOptional = usuarioRepository.findByLogin(login);
        if (usuarioOptional.isEmpty()) {
            return null;
        }
        Usuario usuario = usuarioOptional.get();
        List<String> permissoesByUsuario = grupoUsuarioRepository.findPermissoesByUsuario(usuario);
        usuario.setPermissoes(permissoesByUsuario);
        return usuario;
    }
}
