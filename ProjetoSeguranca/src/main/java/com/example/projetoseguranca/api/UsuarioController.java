package com.example.projetoseguranca.api;


import com.example.projetoseguranca.api.dto.CadastroUsuarioDTO;
import com.example.projetoseguranca.domain.entity.Usuario;
import com.example.projetoseguranca.domain.repository.UsuarioRepository;
import com.example.projetoseguranca.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Usuario> salvar(@RequestBody CadastroUsuarioDTO body) {
        Usuario UsuarioSalvo = usuarioService.salvar(body.getUsuario(), body.getPermissoes());
        return ResponseEntity.ok(UsuarioSalvo);
    }
}
