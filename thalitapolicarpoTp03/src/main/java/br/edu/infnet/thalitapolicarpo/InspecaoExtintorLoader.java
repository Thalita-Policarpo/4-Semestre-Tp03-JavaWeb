package br.edu.infnet.thalitapolicarpo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.thalitapolicarpo.model.domain.Extintor;
import br.edu.infnet.thalitapolicarpo.model.domain.InspecaoExtintor;
import br.edu.infnet.thalitapolicarpo.model.service.InspecaoExtintorService;

@Component
@Order(3)
public class InspecaoExtintorLoader implements ApplicationRunner {
	
	@Autowired
    private InspecaoExtintorService inspecaoExtintorService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Extintor extintor1 = new Extintor(3,"Localização 1", "12345", "123456789", "AP", "10L", "01/01/2025", 2027);
        InspecaoExtintor inspecaoExtintor1 = new InspecaoExtintor(extintor1, "01/01/2025", true, true, true, true, true, true, true, true);
        inspecaoExtintorService.realizarInspecao(1, inspecaoExtintor1);

        Extintor extintor2 = new Extintor(4,"Localização 2", "67890", "987654321", "CO2", "5KG", "01/01/2026", 2028);
        InspecaoExtintor inspecaoExtintor2 = new InspecaoExtintor(extintor2, "01/01/2026", true, true, true, true, true, true, true, true);
        inspecaoExtintorService.realizarInspecao(2, inspecaoExtintor2);
        
        System.out.println("Número de Inspeções de Extintor: " + inspecaoExtintorService.obterTodos().size());
    }
}
