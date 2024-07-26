package com.example.projetoseguranca.domain.repository;

import com.example.projetoseguranca.domain.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GrupoRepository extends JpaRepository<Grupo, String> {


    Optional<Grupo> findByNome(String nome);
}
