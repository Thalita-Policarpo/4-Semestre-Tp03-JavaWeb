package br.edu.infnet.thalitapolicarpo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.thalitapolicarpo.model.domain.Hidrante;
import br.edu.infnet.thalitapolicarpo.model.domain.InspecoesHidrante;
import br.edu.infnet.thalitapolicarpo.model.service.InspecoesHidranteService;

@SpringBootTest
public class InspecoesHidranteServiceTest {

    @Autowired
    private InspecoesHidranteService service;

    @Test
    public void testRealizarInspecaoEmConformidade() {
        Hidrante hidrante = new Hidrante(); 
        InspecoesHidrante inspecao = new InspecoesHidrante(hidrante, "01/01/2022", true, true, true, 2, Arrays.asList(15, 15), Arrays.asList("01/01/2025", "01/01/2025"));
        service.realizarInspecao(1, inspecao);
        InspecoesHidrante inspecaoSalva = service.obterPorNumeroControleInterno(1);
        assertNotNull(inspecaoSalva);
        assertEquals("Equipamento em conformidade!", inspecaoSalva.getStatus());
    }
    
    @Test
    public void testRealizarInspecaoEmNaoConformidade() {
        Hidrante hidrante = new Hidrante(); 
        InspecoesHidrante inspecao = new InspecoesHidrante(hidrante, "01/01/2022", true, true, true, 2, Arrays.asList(30, 15), Arrays.asList("01/01/2025", "01/01/2025"));
        service.realizarInspecao(1, inspecao);
        InspecoesHidrante inspecaoSalva = service.obterPorNumeroControleInterno(1);
        assertNotNull(inspecaoSalva);
        assertEquals("Equipamento em não conformidade!", inspecaoSalva.getStatus());
    }
    
    @Test
    public void testRealizarInspecaoComValidadeExpirada() {
        Hidrante hidrante = new Hidrante(); 
        InspecoesHidrante inspecao = new InspecoesHidrante(hidrante, "01/01/2022", true, true, true, 2, Arrays.asList(15, 15), Arrays.asList("01/01/2020", "01/01/2020"));
        service.realizarInspecao(1, inspecao);
        InspecoesHidrante inspecaoSalva = service.obterPorNumeroControleInterno(1);
        assertNotNull(inspecaoSalva);
        assertEquals("Equipamento em não conformidade!", inspecaoSalva.getStatus());
    }

    @Test
    public void testRealizarInspecaoComCampoBooleanoFalso() {
        Hidrante hidrante = new Hidrante(); 
        InspecoesHidrante inspecao = new InspecoesHidrante(hidrante, "01/01/2022", false, false, false, 2, Arrays.asList(15, 15), Arrays.asList("01/01/2025", "01/01/2025"));
        service.realizarInspecao(1, inspecao);
        InspecoesHidrante inspecaoSalva = service.obterPorNumeroControleInterno(1);
        assertNotNull(inspecaoSalva);
        assertEquals("Equipamento em não conformidade!", inspecaoSalva.getStatus());
    }


    @Test
    public void testExcluirInspecao() {
        service.excluirInspecao(1);
        assert(service.obterPorNumeroControleInterno(1) == null);
    }

    @Test
    public void testObterPorNumeroControleInterno() {
        Hidrante hidrante = new Hidrante(); 
        InspecoesHidrante inspecao = new InspecoesHidrante(hidrante, "01/01/2022", true, true, true, 1, Arrays.asList(30), Arrays.asList("01/01/2025"));
        service.realizarInspecao(1, inspecao);
        InspecoesHidrante inspecaoSalva = service.obterPorNumeroControleInterno(1);
        assertNotNull(inspecaoSalva);
    }

    @Test
    public void testObterTodos() {
        Collection<InspecoesHidrante> todasInspecoes = service.obterTodos();
        assertNotNull(todasInspecoes);
    }
}
