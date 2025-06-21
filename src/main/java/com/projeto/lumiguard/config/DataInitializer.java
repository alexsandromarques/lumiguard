package com.projeto.lumiguard.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projeto.lumiguard.model.Denuncia;
import com.projeto.lumiguard.model.TipoFalha;
import com.projeto.lumiguard.repository.DenunciaRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private DenunciaRepository denunciaRepository;

    @PostConstruct
    public void init() {
        if (denunciaRepository.count() == 0) {
            var denuncias = Arrays.asList(
                new Denuncia(null, "Rua das Fronteiras, 120, Boa Vista, Recife - PE, 50070-000", TipoFalha.APAGADO, LocalDateTime.now(), "Poste completamente apagado desde ontem."),
                new Denuncia(null, "Avenida Sul, 155, São José, Recife - PE, 50090-000", TipoFalha.PISCANDO, LocalDateTime.now(), "Poste piscando à noite, oferecendo risco a pedestres."),
                new Denuncia(null, "Rua Imperial, 320, Santo Antônio, Recife - PE, 50080-000", TipoFalha.INTERMITENTE, LocalDateTime.now(), "Poste acende e apaga intermitentemente."),
                new Denuncia(null, "Rua do Sol, 99, Santo Amaro, Recife - PE, 50050-000", TipoFalha.OUTRO, LocalDateTime.now(), "Poste apresenta faíscas e mau funcionamento."),
                new Denuncia(null, "Rua da Aurora, 451, Boa Vista, Recife - PE, 50050-000", TipoFalha.APAGADO, LocalDateTime.now(), "Poste sem iluminação desde o início da semana."),
                new Denuncia(null, "Avenida Norte, 1002, Rosarinho, Recife - PE, 52071-050", TipoFalha.PISCANDO, LocalDateTime.now(), "Poste piscando em frente à parada de ônibus."),
                new Denuncia(null, "Rua Real da Torre, 890, Madalena, Recife - PE, 50720-001", TipoFalha.INTERMITENTE, LocalDateTime.now(), "Poste com funcionamento irregular à noite."),
                new Denuncia(null, "Rua Benfica, 233, Madalena, Recife - PE, 50720-001", TipoFalha.APAGADO, LocalDateTime.now(), "Rua totalmente escura devido à falha na iluminação.")
            );

            denunciaRepository.saveAll(denuncias);
            System.out.println("Dados de teste inseridos com sucesso!");
        }
    }
}
