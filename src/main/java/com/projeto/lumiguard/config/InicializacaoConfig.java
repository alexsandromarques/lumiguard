package com.projeto.lumiguard.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.projeto.lumiguard.model.Usuario;
import com.projeto.lumiguard.repository.UsuarioRepository;

@Configuration
public class InicializacaoConfig {

    @Bean
    CommandLineRunner criarUsuarioPadrao(UsuarioRepository usuarioRepository) {
        return args -> {
            String email = "admin@lumiguard.com";
            if (usuarioRepository.findByEmail(email).isEmpty()) {
                Usuario admin = new Usuario();
                admin.setNome("Administrador");
                admin.setEmail(email);
                admin.setSenha(new BCryptPasswordEncoder().encode("123456"));

                usuarioRepository.save(admin);
                System.out.println("Usuário admin criado com sucesso.");
            }
        };
    }
}
