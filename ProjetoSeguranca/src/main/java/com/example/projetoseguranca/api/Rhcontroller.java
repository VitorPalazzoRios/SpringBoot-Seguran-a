package com.example.projetoseguranca.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rh")
public class Rhcontroller {

    @GetMapping("/tecnico")
    @PreAuthorize("hasAnyRole('TECNICO_RH','GERENTE_RH','ADMIN')")
    public ResponseEntity<String> TECNICO_RH() {
        return ResponseEntity.ok("Rota do tecnico");
    }

    @GetMapping("/gerente")
    @PreAuthorize("hasAnyRole('GERENTE_RH','ADMIN')")
    public ResponseEntity<String> GERENTE_RH() {
        return ResponseEntity.ok("Rota do gerente");

    }
}
