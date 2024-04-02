package br.edu.infnet.thalitapolicarpo.model.service;

import org.springframework.stereotype.Service;
import br.edu.infnet.thalitapolicarpo.model.domain.Hidrante;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HidranteService {
	
	private Map<Integer, Hidrante> hidrantes = new HashMap<>();

	
    public void incluirEquipamento(Hidrante hidrante) {
        this.hidrantes.put(hidrante.getNumeroControleInterno(), hidrante);
        System.out.println("Hidrante incluído com sucesso!");
    }

   
    public void excluirEquipamento(int numeroControleInterno) {
        this.hidrantes.remove(numeroControleInterno);
        System.out.println("Hidrante excluido com sucesso!");
    }

    
    public Hidrante obterPorNumeroControleInterno(int numeroControleInterno) {
		return this.hidrantes.get(numeroControleInterno);
    }

    
    public List<Hidrante> obterTodos() {
		return this.hidrantes.values().stream().collect(Collectors.toList());
    }
}

