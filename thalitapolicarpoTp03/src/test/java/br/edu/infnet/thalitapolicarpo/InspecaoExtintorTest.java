package br.edu.infnet.thalitapolicarpo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.thalitapolicarpo.model.domain.Extintor;
import br.edu.infnet.thalitapolicarpo.model.domain.InspecaoExtintor;
import br.edu.infnet.thalitapolicarpo.model.service.ExtintorService;
import br.edu.infnet.thalitapolicarpo.model.service.InspecaoExtintorService;

@SpringBootTest
public class InspecaoExtintorTest {

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
    
    @Test
    public void testConstrutorPadrao() {
        InspecaoExtintor inspecaoExtintor = new InspecaoExtintor();
        assertNull(inspecaoExtintor.getExtintor());
        assertNull(inspecaoExtintor.getDataInspecao());
        assertFalse(inspecaoExtintor.isSinalizado());
        assertFalse(inspecaoExtintor.isDesobstruido());
        assertFalse(inspecaoExtintor.isManometroPressaoAdequada());
        assertFalse(inspecaoExtintor.isGatilhoBoasCondicoes());
        assertFalse(inspecaoExtintor.isMangoteBoasCondicoes());
        assertFalse(inspecaoExtintor.isRotuloPinturaBoasCondicoes());
        assertFalse(inspecaoExtintor.isSuporteBoasCondicoes());
        assertFalse(inspecaoExtintor.isLacreIntacto());
        assertNull(inspecaoExtintor.getStatus());
    }

    @Test
    public void testSetters() {
        Extintor extintor = new Extintor(1,"Localização 1", "12345", "123456789", "AP", "10L", "01/01/2025", 2027);
        InspecaoExtintor inspecaoExtintor = new InspecaoExtintor();

        // Testando os setters
        inspecaoExtintor.setExtintor(extintor);
        inspecaoExtintor.setDataInspecao("01/01/2025");
        inspecaoExtintor.setSinalizado(true);
        inspecaoExtintor.setDesobstruido(true);
        inspecaoExtintor.setManometroPressaoAdequada(true);
        inspecaoExtintor.setGatilhoBoasCondicoes(true);
        inspecaoExtintor.setMangoteBoasCondicoes(true);
        inspecaoExtintor.setRotuloPinturaBoasCondicoes(true);
        inspecaoExtintor.setSuporteBoasCondicoes(true);
        inspecaoExtintor.setLacreIntacto(true);

        // Verificando se os valores foram definidos corretamente
        assertEquals(extintor, inspecaoExtintor.getExtintor());
        assertEquals("01/01/2025", inspecaoExtintor.getDataInspecao());
        assertTrue(inspecaoExtintor.isSinalizado());
        assertTrue(inspecaoExtintor.isDesobstruido());
        assertTrue(inspecaoExtintor.isManometroPressaoAdequada());
        assertTrue(inspecaoExtintor.isGatilhoBoasCondicoes());
        assertTrue(inspecaoExtintor.isMangoteBoasCondicoes());
        assertTrue(inspecaoExtintor.isRotuloPinturaBoasCondicoes());
        assertTrue(inspecaoExtintor.isSuporteBoasCondicoes());
        assertTrue(inspecaoExtintor.isLacreIntacto());
    }
    
    @Test
    public void testGetters() {
        Extintor extintor = new Extintor(1,"Localização 1", "12345", "123456789", "AP", "10L", "01/01/2025", 2027);
        extintorService.incluirEquipamento(extintor);
        String dataString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        InspecaoExtintor inspecaoExtintor = new InspecaoExtintor(extintor, dataString, true, true, true, true, true, true, true, true);
        inspecaoExtintorService.realizarInspecao(1, inspecaoExtintor);
        assertEquals(extintor, inspecaoExtintor.getExtintor());
        assertEquals(dataString, inspecaoExtintor.getDataInspecao());
        assertTrue(inspecaoExtintor.isSinalizado());
        assertTrue(inspecaoExtintor.isDesobstruido());
        assertTrue(inspecaoExtintor.isManometroPressaoAdequada());
        assertTrue(inspecaoExtintor.isGatilhoBoasCondicoes());
        assertTrue(inspecaoExtintor.isMangoteBoasCondicoes());
        assertTrue(inspecaoExtintor.isRotuloPinturaBoasCondicoes());
        assertTrue(inspecaoExtintor.isSuporteBoasCondicoes());
        assertTrue(inspecaoExtintor.isLacreIntacto());
    }

    @Test
    public void testToString() {
        Extintor extintor = new Extintor(1,"Localização 1", "12345", "123456789", "AP", "10L", "01/01/2025", 2027);
        extintorService.incluirEquipamento(extintor);
        String dataString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        InspecaoExtintor inspecaoExtintor = new InspecaoExtintor(extintor, dataString, true, true, true, true, true, true, true, true);
        inspecaoExtintorService.realizarInspecao(1, inspecaoExtintor);
        String expected = extintor
                + "\nData da Inspeção: "+ dataString 
                + "\nSinalizado: true"
                + "\nDesobstruido: true"
                + "\nManometro com pressão adequada: true"
                + "\nGatilho em boas condições: true"
                + "\nMangote em boas condições: true"
                + "\nRotulo e pintura em boas condições: true"
                + "\nSuporte em boas condições: true"
                + "\nLacre intacto: true"
                + "\nSituação do equipamento: " + inspecaoExtintor.getStatus();
        assertEquals(expected, inspecaoExtintor.toString());
    }

}
