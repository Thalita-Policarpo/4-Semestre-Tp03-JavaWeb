package br.edu.infnet.thalitapolicarpo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.thalitapolicarpo.model.domain.Extintor;
import br.edu.infnet.thalitapolicarpo.model.domain.InspecaoExtintor;
import br.edu.infnet.thalitapolicarpo.model.service.ExtintorService;
import br.edu.infnet.thalitapolicarpo.model.service.InspecaoExtintorService;

@SpringBootTest
public class InspecaoExtintorServiceTest {

	@Autowired
    private InspecaoExtintorService inspecaoExtintorService;
    
    @Autowired
    private ExtintorService extintorService;
	
    @Test
    public void testRealizarInspecao() {
        Extintor extintor = new Extintor(1,"Localização 1", "12345", "123456789", "AP", "10L", "01/01/2025", 2027);
        extintorService.incluirEquipamento(extintor);
        InspecaoExtintor inspecaoExtintor = new InspecaoExtintor(extintor, "01/01/2025", true, true, true, true, true, true, true, true);
        inspecaoExtintorService.realizarInspecao(1, inspecaoExtintor);
        assertNotNull(inspecaoExtintorService.obterPorNumeroControleInterno(1));
    }
    
    @Test
    public void testRealizarInspecaoEmConformidade() {
        Extintor extintor = new Extintor(5,"Localização 4", "22222", "333333333", "AP", "10L", "01/01/2025", 2027);
        extintorService.incluirEquipamento(extintor);
        InspecaoExtintor inspecaoExtintor = new InspecaoExtintor(extintor, "01/01/2025", true, true, true, true, true, true, true, true);
        inspecaoExtintorService.realizarInspecao(5, inspecaoExtintor);
        assertEquals("Equipamento em conformidade!", inspecaoExtintorService.obterPorNumeroControleInterno(5).getStatus());
    }
    
    @Test
    public void testRealizarInspecaoNaoConformidade() {
        Extintor extintor = new Extintor(4,"Localização 4", "22222", "333333333", "AP", "10L", "01/01/2025", 2027);
        extintorService.incluirEquipamento(extintor);
        InspecaoExtintor inspecaoExtintor = new InspecaoExtintor(extintor, "01/01/2025", false, true, true, true, true, true, true, true);
        inspecaoExtintorService.realizarInspecao(4, inspecaoExtintor);
        assertEquals("Equipamento em não conformidade!", inspecaoExtintorService.obterPorNumeroControleInterno(4).getStatus());
    }

    @Test
    public void testExcluirInspecao() {
        Extintor extintor = new Extintor(2,"Localização 2", "67890", "987654321", "CO2", "5KG", "01/01/2026", 2028);
        InspecaoExtintor inspecaoExtintor = new InspecaoExtintor(extintor, "01/01/2026", true, true, true, true, true, true, true, true);
        inspecaoExtintorService.realizarInspecao(2, inspecaoExtintor);
        inspecaoExtintorService.excluirInspecao(2);
        assertNull(inspecaoExtintorService.obterPorNumeroControleInterno(2));
    }

    @Test
    public void testObterPorNumeroControleInterno() {
        Extintor extintor = new Extintor(3,"Localização 3", "11111", "222222222", "AP", "10L", "01/01/2025", 2027);
        extintorService.incluirEquipamento(extintor);
        InspecaoExtintor inspecaoExtintor = new InspecaoExtintor(extintor, "01/01/2025", true, true, true, true, true, true, true, true);
        inspecaoExtintorService.realizarInspecao(3, inspecaoExtintor);
        assertEquals(inspecaoExtintor, inspecaoExtintorService.obterPorNumeroControleInterno(3));
    }

    @Test
    public void testObterTodos() {
        assertTrue(inspecaoExtintorService.obterTodos().size() >= 0);
    }
}
