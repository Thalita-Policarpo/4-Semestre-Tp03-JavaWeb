package br.edu.infnet.thalitapolicarpo.model.Controller;


import br.edu.infnet.thalitapolicarpo.model.domain.InspecoesHidrante;
import br.edu.infnet.thalitapolicarpo.model.service.InspecoesHidranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/inspecoes-hidrante")
public class InspecoesHidranteController {

    @Autowired
    private InspecoesHidranteService inspecoesHidranteService;

    @PostMapping("/{numeroControleInterno}")
    public ResponseEntity<String> criarInspecao(@PathVariable int numeroControleInterno, @RequestBody InspecoesHidrante inspecao) {
        inspecoesHidranteService.realizarInspecao(numeroControleInterno, inspecao);
        return new ResponseEntity<>("Inspeção criada com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping("/{numeroControleInterno}")
    public ResponseEntity<InspecoesHidrante> obterInspecao(@PathVariable int numeroControleInterno) {
        InspecoesHidrante inspecao = inspecoesHidranteService.obterPorNumeroControleInterno(numeroControleInterno);
        if (inspecao != null) {
            return new ResponseEntity<>(inspecao, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{numeroControleInterno}")
    public ResponseEntity<String> atualizarInspecao(@PathVariable int numeroControleInterno, @RequestBody InspecoesHidrante inspecao) {
        InspecoesHidrante inspecaoExistente = inspecoesHidranteService.obterPorNumeroControleInterno(numeroControleInterno);
        if (inspecaoExistente != null) {
            inspecoesHidranteService.atualizarInspecao(numeroControleInterno, inspecao);
            return new ResponseEntity<>("Inspeção atualizada com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Inspeção não encontrada!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{numeroControleInterno}")
    public ResponseEntity<String> deletarInspecao(@PathVariable int numeroControleInterno) {
        InspecoesHidrante inspecao = inspecoesHidranteService.obterPorNumeroControleInterno(numeroControleInterno);
        if (inspecao != null) {
            inspecoesHidranteService.excluirInspecao(numeroControleInterno);
            return new ResponseEntity<>("Inspeção excluída com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Inspeção não encontrada!", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Collection<InspecoesHidrante>> obterTodos() {
        return new ResponseEntity<>(inspecoesHidranteService.obterTodos(), HttpStatus.OK);
    }
}
