package br.edu.infnet.thalitapolicarpo.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.thalitapolicarpo.model.domain.Hidrante;
import br.edu.infnet.thalitapolicarpo.model.domain.InspecoesHidrante;
import br.edu.infnet.thalitapolicarpo.model.service.InspecoesHidranteService;

@SpringBootTest
public class InspecoesHidranteTest {

    @Autowired
    private InspecoesHidranteService inspecoesHidranteService;

    private InspecoesHidrante inspecao;

    @BeforeEach
    public void setUp() {
        Hidrante hidrante = new Hidrante(); // Você precisa definir a classe Hidrante
        inspecao = new InspecoesHidrante(hidrante, "01/01/2022", true, true, true, 2, Arrays.asList(15, 15), Arrays.asList("01/01/2025", "01/01/2025"));
    }

    @Test
    public void testConstrutorPadrao() {
        InspecoesHidrante inspecao = new InspecoesHidrante();
        assertNotNull(inspecao);
    }

    @Test
    public void testConstrutorComParametro() {
        Hidrante hidrante = new Hidrante();
        InspecoesHidrante inspecao = new InspecoesHidrante(hidrante, "01/01/2022", true, true, true, 2, Arrays.asList(15, 15), Arrays.asList("01/01/2025", "01/01/2025"));
        assertNotNull(inspecao);
    }

    @Test
    public void testGettersAndSetters() {
        inspecao.setHidrante(new Hidrante());
        assertNotNull(inspecao.getHidrante());

        inspecao.setDataInspecao("01/01/2025");
        assertEquals("01/01/2025", inspecao.getDataInspecao());

        inspecao.setSinalizado(false);
        assertEquals(false, inspecao.isSinalizado());

        inspecao.setDesobstruido(false);
        assertEquals(false, inspecao.isDesobstruido());

        inspecao.setPossuiChaveStorz(false);
        assertEquals(false, inspecao.isPossuiChaveStorz());

        inspecao.setQuantidadeMangueiras(1);
        assertEquals(1, inspecao.getQuantidadeMangueiras());

        inspecao.setMetragem(Arrays.asList(30));
        assertEquals(Arrays.asList(30), inspecao.getMetragem());

        inspecao.setValidadeMangueiras(Arrays.asList("01/01/2023"));
        assertEquals(Arrays.asList("01/01/2023"), inspecao.getValidadeMangueiras());

        inspecao.setStatus("Equipamento em não conformidade!");
        assertEquals("Equipamento em não conformidade!", inspecao.getStatus());
    }

    @Test
    public void testToString() {
        inspecoesHidranteService.realizarInspecao(1, inspecao);
        InspecoesHidrante inspecaoSalva = inspecoesHidranteService.obterPorNumeroControleInterno(1);
        assertNotNull(inspecaoSalva.toString());
    }

    @Test
    public void testToStringMetragensVazias() {
        inspecao.setMetragem(Collections.emptyList());
        inspecoesHidranteService.realizarInspecao(1, inspecao);
        InspecoesHidrante inspecaoSalva = inspecoesHidranteService.obterPorNumeroControleInterno(1);
        assertNotNull(inspecaoSalva.toString());
    }

    @Test
    public void testToStringValidadesMangueirasVazias() {
        inspecao.setValidadeMangueiras(Collections.emptyList());
        inspecoesHidranteService.realizarInspecao(1, inspecao);
        InspecoesHidrante inspecaoSalva = inspecoesHidranteService.obterPorNumeroControleInterno(1);
        assertNotNull(inspecaoSalva.toString());
    }
    
    @Test
    public void testToStringUmaMetragem() {
        inspecao.setMetragem(Collections.singletonList(30));
        inspecoesHidranteService.realizarInspecao(1, inspecao);
        InspecoesHidrante inspecaoSalva = inspecoesHidranteService.obterPorNumeroControleInterno(1);
        assertTrue(inspecaoSalva.toString().contains("metragem=30"));
    }

    @Test
    public void testToStringUmaValidadeMangueira() {
        inspecao.setValidadeMangueiras(Collections.singletonList("01/01/2023"));
        inspecoesHidranteService.realizarInspecao(1, inspecao);
        InspecoesHidrante inspecaoSalva = inspecoesHidranteService.obterPorNumeroControleInterno(1);
        assertTrue(inspecaoSalva.toString().contains("\nvalidadeMangueiras: 01/01/2023"));
    }

}
