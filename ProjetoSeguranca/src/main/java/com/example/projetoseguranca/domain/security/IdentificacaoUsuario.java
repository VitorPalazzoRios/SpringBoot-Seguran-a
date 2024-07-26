package com.example.projetoseguranca.domain.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentificacaoUsuario {
    private String id;
    private String nome;
    private String login;
    private List<String> permissoes;
    private String senha;

    public IdentificacaoUsuario(String id, String nome, String login, List<String> permissoes) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.permissoes = permissoes;
    }

    public List<String> getPermissoes() {
        if (permissoes == null) {
            permissoes = new ArrayList<>();
        }
        return permissoes;
    }
}
