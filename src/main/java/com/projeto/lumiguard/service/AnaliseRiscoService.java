package com.projeto.lumiguard.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.lumiguard.repository.DenunciaRepository;

@Service
public class AnaliseRiscoService {

	@Autowired
	private DenunciaRepository denunciaRepository;

	public String avaliarRisco(String localizacao) {
		LocalDateTime agora = LocalDateTime.now();
		long ultimas48h = denunciaRepository.findByLocalizacaoAndDataAfter(localizacao, agora.minusHours(48)).size();
		long ultimos7dias = denunciaRepository.findByLocalizacaoAndDataAfter(localizacao, agora.minusDays(7)).size();

		if (ultimas48h >= 3)
			return "ALTO";
		if (ultimos7dias >= 2)
			return "MÉDIO";
		return "BAIXO";
	}
}
