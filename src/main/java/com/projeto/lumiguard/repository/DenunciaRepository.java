package com.projeto.lumiguard.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto.lumiguard.model.Denuncia;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {
	
    List<Denuncia> findByLocalizacaoAndDataAfter(String localizacao, LocalDateTime data);

}
