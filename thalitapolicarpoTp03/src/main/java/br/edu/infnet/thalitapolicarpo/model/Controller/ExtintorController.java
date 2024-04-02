package br.edu.infnet.thalitapolicarpo.model.Controller;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.thalitapolicarpo.model.domain.Extintor;
import br.edu.infnet.thalitapolicarpo.model.service.ExtintorService;

@RestController
@RequestMapping("/extintor")
public class ExtintorController {

    @Autowired
    private ExtintorService extintorService;

    @PostMapping
    public ResponseEntity<String> incluirEquipamento(@RequestBody Extintor extintor) {
        extintorService.incluirEquipamento(extintor);
        return new ResponseEntity<>("Extintor incluído com sucesso!", HttpStatus.CREATED);
    }

    @DeleteMapping("/{numeroControleInterno}")
    public ResponseEntity<String> excluirExtintor(@PathVariable int numeroControleInterno) {
        extintorService.excluirExtintor(numeroControleInterno);
        return new ResponseEntity<>("Extintor excluído com sucesso!", HttpStatus.OK);
    }

    @GetMapping("/{numeroControleInterno}")
    public ResponseEntity<Extintor> obterPorNumeroControleInterno(@PathVariable int numeroControleInterno) {
        Extintor extintor = extintorService.obterPorNumeroControleInterno(numeroControleInterno);
        return new ResponseEntity<>(extintor, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<Extintor>> obterTodos() {
        Collection<Extintor> extintores = extintorService.obterTodos();
        return new ResponseEntity<>(extintores, HttpStatus.OK);
    }
    
    @PutMapping("/{numeroControleInterno}")
    public ResponseEntity<String> atualizarEquipamento(@PathVariable int numeroControleInterno, @RequestBody Extintor extintor) {
        Extintor extintorExistente = extintorService.obterPorNumeroControleInterno(numeroControleInterno);
        if (extintorExistente != null) {
            extintorService.excluirExtintor(numeroControleInterno);
            extintorService.incluirEquipamento(extintor);
            return new ResponseEntity<>("Extintor atualizado com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Extintor não encontrado!", HttpStatus.NOT_FOUND);
        }
    }
}
