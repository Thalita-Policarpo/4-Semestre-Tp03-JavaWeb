package br.edu.infnet.thalitapolicarpo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.thalitapolicarpo.model.domain.Extintor;
import br.edu.infnet.thalitapolicarpo.model.service.ExtintorService;

@Component
@Order(1)
public class ExtintorLoader implements ApplicationRunner {
	
	@Autowired
    private ExtintorService extintorService = new ExtintorService();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        extintorService.incluirEquipamento(new Extintor(1,"Localização inicial 1", "12345", "123456789", "AP", "10L", "01/12/2024", 2027));
        extintorService.incluirEquipamento(new Extintor(2,"Localização inicial 2", "67890", "987654321", "CO2", "6KG", "01/07/2024", 2025));
        
        System.out.println("Número de Extintor: " + extintorService.obterTodos().size());
    }
}
