package br.edu.infnet.thalitapolicarpo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.thalitapolicarpo.model.domain.Hidrante;
import br.edu.infnet.thalitapolicarpo.model.domain.InspecoesHidrante;
import br.edu.infnet.thalitapolicarpo.model.service.HidranteService;
import br.edu.infnet.thalitapolicarpo.model.service.InspecoesHidranteService;

@Component
@Order(4)
public class InspecoesHidranteLoader implements CommandLineRunner {

	@Autowired
    private InspecoesHidranteService inspecoesHidranteService;

	@Autowired
    private HidranteService hidranteService;
	
    @Override
    public void run(String... args) throws Exception {
    	Hidrante hidrante1 = new Hidrante(3, "Prédio 1", "01/01/2025", "60cm", "Hidrante de Superfície - Coluna úmida", "2\"", "Vermelho");
    	InspecoesHidrante inspecaoHidrante1 = new  InspecoesHidrante(hidrante1, "01/01/2022", true, true, true, 2, Arrays.asList(15, 15), Arrays.asList("01/01/2025", "01/01/2025"));
    	hidranteService.incluirEquipamento(hidrante1);
    	inspecoesHidranteService.realizarInspecao(3, inspecaoHidrante1);
    	
    	
    	Hidrante hidrante2 = new Hidrante(4, "Prédio 2", "01/01/2025", "60cm", "Hidrante de Superfície - Coluna úmida", "2\"", "Vermelho");
    	InspecoesHidrante inspecaoHidrante2 = new  InspecoesHidrante(hidrante2, "01/01/2022", true, true, true, 2, Arrays.asList(15, 15), Arrays.asList("01/01/2025", "01/01/2025"));
    	hidranteService.incluirEquipamento(hidrante2);
    	inspecoesHidranteService.realizarInspecao(4, inspecaoHidrante2);
    	
    	System.out.println("Número de InspeçõesHidrante: " + inspecoesHidranteService.obterTodos().size());
    }
}
