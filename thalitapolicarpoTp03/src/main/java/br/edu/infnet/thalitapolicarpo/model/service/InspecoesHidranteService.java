package br.edu.infnet.thalitapolicarpo.model.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.thalitapolicarpo.model.domain.Hidrante;
import br.edu.infnet.thalitapolicarpo.model.domain.InspecoesHidrante;

@Service
public class InspecoesHidranteService {
	
	@Autowired
	private HidranteService hidranteService;

	private Map<Integer, InspecoesHidrante> inspecoes = new HashMap<>();

	
	public void realizarInspecao(int numeroControleInterno, InspecoesHidrante inspecao) {
		Hidrante hidrante = hidranteService.obterPorNumeroControleInterno(numeroControleInterno);
	    if (hidrante != null) {
		        inspecao.setHidrante(hidrante);
			
			// Salvar a data da inspeção
		    inspecao.setDataInspecao(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
	
		    // Verificar a quantidade de mangueiras
		    if (inspecao.getQuantidadeMangueiras() == 2) {
		        // Aqui você precisa verificar se as metragens e as validades das duas mangueiras foram informadas
		        if (inspecao.getMetragem().size() != 2 || inspecao.getValidadeMangueiras().size() != 2) {
		            inspecao.setStatus("Equipamento em não conformidade!");
		            inspecoes.put(numeroControleInterno, inspecao);
		            return;
		        }
		    }
	
		    // Verificar se a soma das metragens das mangueiras é 30m
		    int somaMetragem = 0;
		    for (Integer metragem : inspecao.getMetragem()) {
		        somaMetragem += metragem;
		    }
		    if (somaMetragem != 30) {
		        inspecao.setStatus("Equipamento em não conformidade!");
		        inspecoes.put(numeroControleInterno, inspecao);
		        return;
		    }
	
		    // Verificar todos os campos booleanos
		    if (inspecao.isSinalizado() && inspecao.isDesobstruido() && inspecao.isPossuiChaveStorz()) {
		        // Aqui você precisa verificar se as datas de validade estão dentro da validade
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        LocalDate now = LocalDate.now();
		        for (String validade : inspecao.getValidadeMangueiras()) {
		            LocalDate validadeDate = LocalDate.parse(validade, formatter);
		            if (validadeDate.isBefore(now)) {
		                inspecao.setStatus("Equipamento em não conformidade!");
		                inspecoes.put(numeroControleInterno, inspecao);
		                return;
		            }
		        }
	
		        // Se todas as condições foram atendidas, definir o status como "Equipamento em conformidade!"
		        inspecao.setStatus("Equipamento em conformidade!");
		    } else {
		        inspecao.setStatus("Equipamento em não conformidade!");
		    }
	
		    // Salvar a inspeção
		    inspecoes.put(numeroControleInterno, inspecao);
	    } else {
	        System.out.println("Hidrante não encontrado!");
	    }
	}


	public void atualizarInspecao(int numeroControleInterno, InspecoesHidrante inspecao) {
	    Hidrante hidrante = hidranteService.obterPorNumeroControleInterno(numeroControleInterno);
	    if (hidrante != null && inspecoes.containsKey(numeroControleInterno)) {
	        inspecao.setHidrante(hidrante);
	        inspecoes.put(numeroControleInterno, inspecao);
	    }
	}

	
    public void excluirInspecao(int numeroControleInterno) {
        inspecoes.remove(numeroControleInterno);
    }

    public InspecoesHidrante obterPorNumeroControleInterno(int numeroControleInterno) {
		return inspecoes.get(numeroControleInterno);
    }

    public Collection<InspecoesHidrante> obterTodos() {
		return inspecoes.values();
    }
}

