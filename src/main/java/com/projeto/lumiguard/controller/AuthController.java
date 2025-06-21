package com.projeto.lumiguard.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.projeto.lumiguard.model.Usuario;
import com.projeto.lumiguard.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Usuario loginData) {
		Optional<Usuario> userOpt = usuarioRepository.findByEmail(loginData.getEmail());

		if (userOpt.isPresent()) {
			Usuario user = userOpt.get();

			if (passwordEncoder.matches(loginData.getSenha(), user.getSenha())) {
				// Evita retornar a senha no JSON
				user.setSenha(null);
				return ResponseEntity.ok(user);
			}
		}

		return ResponseEntity.status(401).body("Email ou senha inválidos");
	}
}
