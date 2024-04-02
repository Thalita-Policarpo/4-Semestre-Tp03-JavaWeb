package br.edu.infnet.thalitapolicarpo.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.thalitapolicarpo.model.domain.Extintor;

@Service
public class ExtintorService {
    private Map<Integer, Extintor> extintores = new HashMap<>();

    public void incluirEquipamento(Extintor extintor) {
        extintores.put(extintor.getNumeroControleInterno(), extintor);
        System.out.println("Extintor incluído com sucesso!");
    }

    public void excluirExtintor(int numeroControleInterno) {
        extintores.remove(numeroControleInterno);
        System.out.println("Extintor excluído com sucesso!");
    }

    public Extintor obterPorNumeroControleInterno(int numeroControleInterno) {
        return extintores.get(numeroControleInterno);
    }

    public Collection<Extintor> obterTodos() {
            	
    	return extintores.values();
    }
}
