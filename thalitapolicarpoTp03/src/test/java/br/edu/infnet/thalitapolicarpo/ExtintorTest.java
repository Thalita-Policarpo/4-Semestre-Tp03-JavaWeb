package br.edu.infnet.thalitapolicarpo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.thalitapolicarpo.model.domain.Extintor;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ExtintorTest {

    @Test
    public void testaCriacaoExtintor() {
        Extintor extintor = new Extintor(1,"Localização 1", "12345", "123456789", "AP", "10L", "01/01/2025", 2027);
        assertNotNull(extintor, "O extintor não foi criado corretamente");
    }

    @Test
    public void testaGettersSetters() {
        Extintor extintor = new Extintor();
        extintor.setNumeroControleInterno(1);
        extintor.setLocalizacao("Localização 1");
        extintor.setNumeroCilindro("12345");
        extintor.setNumeroSeloInmetro("123456789");
        extintor.setCargaExtintora("AP");
        extintor.setCapacidade("10L");
        extintor.setDataVencimento("01/01/2025");
        extintor.setProximoTesteHidrostatico(2027);

        assertEquals(1, extintor.getNumeroControleInterno());
        assertEquals("Localização 1", extintor.getLocalizacao());
        assertEquals("12345", extintor.getNumeroCilindro());
        assertEquals("123456789", extintor.getNumeroSeloInmetro());
        assertEquals("AP", extintor.getCargaExtintora());
        assertEquals("10L", extintor.getCapacidade());
        assertEquals("01/01/2025", extintor.getDataVencimento());
        assertEquals(2027, extintor.getProximoTesteHidrostatico());
    }

    @Test
    public void testaToString() {
        Extintor extintor = new Extintor(1,"Localização 1", "12345", "123456789", "AP", "10L", "01/01/2025", 2027);
        String esperado = "\nNº Controle Interno:1"
                        + "\nLocalização:Localização 1"
                        + "\nExtintor:12345"
                        + "\nSelo do Inmetro:123456789"
                        + "\nCarga Extintora:AP"
                        + "\nCapacidade:10L"
                        + "\nData de vencimento:01/01/2025"
                        + "\nProximo Teste Hidrostatico:2027";
        assertEquals(esperado, extintor.toString());
    }
}
