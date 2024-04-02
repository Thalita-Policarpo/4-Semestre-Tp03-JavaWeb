package br.edu.infnet.thalitapolicarpo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.infnet.thalitapolicarpo.model.domain.Hidrante;
import br.edu.infnet.thalitapolicarpo.model.service.HidranteService;

public class HidranteServiceTest {
    private HidranteService hidranteService;
    private Hidrante hidrante;

    // Método que é executado antes de cada teste
    @BeforeEach
    public void setUp() {
        hidranteService = new HidranteService();
        hidrante = new Hidrante(1, "Localização 1", "01/01/2020", "60cm", "Hidrante de Superfície - Coluna úmida", "50mm", "Vermelho");
    }

    // Teste para verificar se o método incluirEquipamento está funcionando corretamente
    @Test
    public void testIncluirEquipamento() {
        hidranteService.incluirEquipamento(hidrante);
        assertEquals(hidrante, hidranteService.obterPorNumeroControleInterno(1));
    }

    // Teste para verificar se o método excluirEquipamento está funcionando corretamente
    @Test
    public void testExcluirEquipamento() {
        hidranteService.incluirEquipamento(hidrante);
        hidranteService.excluirEquipamento(1);
        assertNull(hidranteService.obterPorNumeroControleInterno(1));
    }

    // Teste para verificar se o método obterPorNumeroControleInterno está funcionando corretamente
    @Test
    public void testObterPorNumeroControleInterno() {
        hidranteService.incluirEquipamento(hidrante);
        assertEquals(hidrante, hidranteService.obterPorNumeroControleInterno(1));
    }

    // Teste para verificar se o método obterTodos está funcionando corretamente
    @Test
    public void testObterTodos() {
        hidranteService.incluirEquipamento(hidrante);
        assertTrue(hidranteService.obterTodos().contains(hidrante));
    }
}

