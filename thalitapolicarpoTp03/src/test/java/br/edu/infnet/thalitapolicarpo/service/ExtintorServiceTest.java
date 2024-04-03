package br.edu.infnet.thalitapolicarpo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.thalitapolicarpo.model.domain.Extintor;
import br.edu.infnet.thalitapolicarpo.model.service.ExtintorService;

@SpringBootTest
public class ExtintorServiceTest {
    private ExtintorService extintorService;
    private Extintor extintor1;
    private Extintor extintor2;

    @BeforeEach
    public void setUp() {
        extintorService = new ExtintorService();
        extintor1 = new Extintor(1,"Localização 1", "12345", "123456789", "AP", "10L", "01/01/2025", 2027);
        extintor2 = new Extintor(2,"Localização 2", "67890", "987654321", "CO2", "5KG", "01/01/2026", 2028);
    }

    @Test
    public void testIncluirEquipamento() {
        extintorService.incluirEquipamento(extintor1);
        assertEquals(extintor1, extintorService.obterPorNumeroControleInterno(1));
    }

    @Test
    public void testExcluirExtintor() {
        extintorService.incluirEquipamento(extintor1);
        extintorService.excluirExtintor(1);
        assertNull(extintorService.obterPorNumeroControleInterno(1));
    }

    @Test
    public void testObterPorNumeroControleInterno() {
        extintorService.incluirEquipamento(extintor1);
        assertEquals(extintor1, extintorService.obterPorNumeroControleInterno(1));
    }

    @Test
    public void testObterTodos() {
        extintorService.incluirEquipamento(extintor1);
        extintorService.incluirEquipamento(extintor2);
        Collection<Extintor> todosExtintores = extintorService.obterTodos();
        assertEquals(2, todosExtintores.size());
        assertTrue(todosExtintores.contains(extintor1));
        assertTrue(todosExtintores.contains(extintor2));
    }
}
