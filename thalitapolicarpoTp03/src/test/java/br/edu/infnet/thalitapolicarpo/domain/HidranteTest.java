package br.edu.infnet.thalitapolicarpo.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import br.edu.infnet.thalitapolicarpo.model.domain.Hidrante;

public class HidranteTest {

    // Teste para verificar se o hidrante é criado corretamente
    @Test
    public void testCriarHidrante() {
        Hidrante hidrante = new Hidrante(1, "Localização 1", "01/01/2020", "2m", "Tipo 1", "50mm", "Vermelho");
        assertEquals(1, hidrante.getNumeroControleInterno());
        assertEquals("Localização 1", hidrante.getLocalizacao());
        assertEquals("01/01/2020", hidrante.getDataDeInstalacao());
        assertEquals("2m", hidrante.getAlturaDeFixacao());
        assertEquals("Tipo 1", hidrante.getTipoDeHidrante());
        assertEquals("50mm", hidrante.getDiametroRegistroGlobo());
        assertEquals("Vermelho", hidrante.getCorDaTubulacao());
    }

    // Teste para verificar se a data de instalação do hidrante é definida corretamente
    @Test
    public void testDefinirDataDeInstalacao() {
        Hidrante hidrante = new Hidrante();
        hidrante.setDataDeInstalacao("02/02/2020");
        assertEquals("02/02/2020", hidrante.getDataDeInstalacao());
    }

    // Teste para verificar se a altura de fixação do hidrante é definida corretamente
    @Test
    public void testDefinirAlturaDeFixacao() {
        Hidrante hidrante = new Hidrante();
        hidrante.setAlturaDeFixacao("3m");
        assertEquals("3m", hidrante.getAlturaDeFixacao());
    }

    // Teste para verificar se o tipo de hidrante é definido corretamente
    @Test
    public void testDefinirTipoDeHidrante() {
        Hidrante hidrante = new Hidrante();
        hidrante.setTipoDeHidrante("Tipo 2");
        assertEquals("Tipo 2", hidrante.getTipoDeHidrante());
    }

    // Teste para verificar se o diâmetro do registro globo do hidrante é definido corretamente
    @Test
    public void testDefinirDiametroRegistroGlobo() {
        Hidrante hidrante = new Hidrante();
        hidrante.setDiametroRegistroGlobo("60mm");
        assertEquals("60mm", hidrante.getDiametroRegistroGlobo());
    }

    // Teste para verificar se a cor da tubulação do hidrante é definida corretamente
    @Test
    public void testDefinirCorDaTubulacao() {
        Hidrante hidrante = new Hidrante();
        hidrante.setCorDaTubulacao("Azul");
        assertEquals("Azul", hidrante.getCorDaTubulacao());
    }
    
 // Teste para verificar se o método toString do hidrante retorna a string correta
    @Test
    public void testToString() {
        Hidrante hidrante = new Hidrante(1, "Localização 1", "01/01/2020", "2m", "Tipo 1", "50mm", "Vermelho");
        String esperado = "Data de instalação: 01/01/2020\nAltura de fixação: 2m\nTipo de Hidrante: Tipo 1\nDiametro do Registro Globo: 50mm\nCor da tubulação=Vermelho";
        assertEquals(esperado, hidrante.toString());
    }

}
