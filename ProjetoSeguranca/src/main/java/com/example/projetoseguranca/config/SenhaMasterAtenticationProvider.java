package com.example.projetoseguranca.config;

import com.example.projetoseguranca.domain.security.CustomAuthentication;
import com.example.projetoseguranca.domain.security.IdentificacaoUsuario;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public class SenhaMasterAtenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        var login = authentication.getName();
        var senha = authentication.getCredentials().toString();


        String loginMaster = "master";
        String senhaMaster = "@321";

        IdentificacaoUsuario identificacaoUsuario = new IdentificacaoUsuario("Sou Master" , "Master", "Login Master", List.of("ROLE_ADMIN"));

        if (login.equals(loginMaster) && senha.equals(senhaMaster)) {
            return new CustomAuthentication(identificacaoUsuario);
        }


        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
