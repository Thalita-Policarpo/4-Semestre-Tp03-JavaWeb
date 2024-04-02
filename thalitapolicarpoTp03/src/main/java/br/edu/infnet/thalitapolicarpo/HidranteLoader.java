package br.edu.infnet.thalitapolicarpo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.thalitapolicarpo.model.domain.Hidrante;
import br.edu.infnet.thalitapolicarpo.model.service.HidranteService;

@Component
@Order(2)
public class HidranteLoader implements CommandLineRunner {

    @Autowired
    private HidranteService hidranteService;

    @Override
    public void run(String... args) throws Exception {
        
        hidranteService.incluirEquipamento(new Hidrante(1, "Localização 1", "01/01/2025", "60cm", "Hidrante de Superfície - Coluna úmida", "2\"", "Vermelho"));
        hidranteService.incluirEquipamento(new Hidrante(2, "Localização 2", "01/01/2026", "60cm", "Hidrante de Superfície - Coluna úmida", "2\"", "Preto"));
        
        
        System.out.println("Número de Hidrantes: " + hidranteService.obterTodos().size());
    }
}
