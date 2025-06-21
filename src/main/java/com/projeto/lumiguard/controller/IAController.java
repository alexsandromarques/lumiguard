package com.projeto.lumiguard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.lumiguard.ia.IAService;

@RestController
@RequestMapping("/api/ia")
public class IAController {

	@Autowired
	private IAService iaService;

	@GetMapping("/prever")
	public ResponseEntity<String> prever(@RequestParam String bairro) {
		try {
			String prioridade = iaService.preverPrioridade(bairro);
			return ResponseEntity.ok("Prioridade prevista: " + prioridade);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro ao prever prioridade: " + e.getMessage());
		}
	}
}
