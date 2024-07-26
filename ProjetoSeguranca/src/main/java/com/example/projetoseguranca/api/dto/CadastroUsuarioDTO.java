package com.example.projetoseguranca.api.dto;

import com.example.projetoseguranca.domain.entity.Usuario;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
public class CadastroUsuarioDTO {
    private Usuario usuario;
    private List<String> permissoes;
}
