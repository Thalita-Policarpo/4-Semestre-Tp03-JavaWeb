package br.edu.infnet.thalitapolicarpo.model.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.thalitapolicarpo.model.domain.Extintor;
import br.edu.infnet.thalitapolicarpo.model.domain.InspecaoExtintor;

@Service
public class InspecaoExtintorService {
    private Map<Integer, InspecaoExtintor> inspecoes = new HashMap<>();
    
    @Autowired
    private ExtintorService extintorService;

    public void realizarInspecao(int numeroControleInterno, InspecaoExtintor inspecaoExtintor) {
        Extintor extintor = extintorService.obterPorNumeroControleInterno(numeroControleInterno);
        if (extintor != null) {
            inspecaoExtintor.setExtintor(extintor);
            inspecaoExtintor.setDataInspecao(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
            // Verifica se todas as perguntas foram respondidas com "Sim" e se as datas de validade do extintor e teste hidrostático estão dentro da validade
            if (inspecaoExtintor.isSinalizado() && inspecaoExtintor.isDesobstruido() && inspecaoExtintor.isManometroPressaoAdequada() &&
                inspecaoExtintor.isGatilhoBoasCondicoes() && inspecaoExtintor.isMangoteBoasCondicoes() && inspecaoExtintor.isRotuloPinturaBoasCondicoes() &&
                inspecaoExtintor.isSuporteBoasCondicoes() && inspecaoExtintor.isLacreIntacto() && 
                LocalDateTime.now().getYear() <= extintor.getProximoTesteHidrostatico() &&
                LocalDate.parse(extintor.getDataVencimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).isAfter(LocalDate.now())) {
                inspecaoExtintor.setStatus("Equipamento em conformidade!");
            } else {
                inspecaoExtintor.setStatus("Equipamento em não conformidade!");
            }
            inspecoes.put(numeroControleInterno, inspecaoExtintor);
            System.out.println("Inspeção realizada com sucesso!");
        } else {
            System.out.println("Extintor não encontrado!");
        }
    }

    public void atualizarInspecao(int numeroControleInterno, InspecaoExtintor inspecaoExtintor) {
        if(inspecoes.containsKey(numeroControleInterno)) {
            inspecoes.put(numeroControleInterno, inspecaoExtintor);
        }
    }

    public void excluirInspecao(int numeroControleInterno) {
        inspecoes.remove(numeroControleInterno);
        System.out.println("Inspeção excluída com sucesso!");
    }

    public InspecaoExtintor obterPorNumeroControleInterno(int numeroControleInterno) {
        return inspecoes.get(numeroControleInterno);
    }

    public Collection<InspecaoExtintor> obterTodos() {
        return inspecoes.values();
    }
}
