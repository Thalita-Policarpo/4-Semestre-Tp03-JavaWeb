package br.edu.infnet.thalitapolicarpo.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.thalitapolicarpo.model.domain.Equipamento;

@SpringBootTest
public class EquipamentoTest {

	@Test
	public void testeConstrutorPadrao() {
		Equipamento equipamento = new Equipamento() {
		};
		assertNotNull(equipamento);
	}

	@Test
	public void testeConstrutorParametrizado() {
		Equipamento equipamento = new Equipamento(01, "prédio2") {
		};
		assertNotNull(equipamento);
		assertEquals(01, equipamento.getNumeroControleInterno());
		assertEquals("prédio2", equipamento.getLocalizacao());
	}

	@Test
	public void testeSettersAndGetters() {
		Equipamento equipamento = new Equipamento() {
		};
		equipamento.setNumeroControleInterno(02);
		equipamento.setLocalizacao("prédio3");
		assertEquals(02, equipamento.getNumeroControleInterno());
		assertEquals("prédio3", equipamento.getLocalizacao());
	}

	@Test
	public void testeToString() {
		Equipamento equipamento = new Equipamento(01, "prédio2") {
		};
		String expected = "NºControle Interno: 1\nLocalização: prédio2";
		assertEquals(expected, equipamento.toString());
	}
}
