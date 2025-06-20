package com.projeto.lumiguard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projeto.lumiguard.model.Denuncia;
import com.projeto.lumiguard.service.AnaliseRiscoService;
import com.projeto.lumiguard.repository.DenunciaRepository;

@RestController
@RequestMapping("/api/denuncias")
public class DenunciaController {

    @Autowired
    private DenunciaRepository repository;

    @Autowired
    private AnaliseRiscoService riscoService;

	@PostMapping("/criar")
    public ResponseEntity<Denuncia> criar(@RequestBody Denuncia denuncia) {
        denuncia.setData(java.time.LocalDateTime.now());
        return ResponseEntity.ok(repository.save(denuncia));
    }

    @GetMapping("/risco/{localizacao}")
    public ResponseEntity<String> risco(@PathVariable String localizacao) {
        String risco = riscoService.avaliarRisco(localizacao);
        return ResponseEntity.ok(risco);
    }

	@GetMapping("/listar")
    public List<Denuncia> listar() {
        return repository.findAll();
    }
}
