package br.edu.infnet.thalitapolicarpo.model.Controller;

import br.edu.infnet.thalitapolicarpo.model.domain.InspecaoExtintor;
import br.edu.infnet.thalitapolicarpo.model.service.InspecaoExtintorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/inspecao-extintor")
public class InspecaoExtintorController {

    @Autowired
    private InspecaoExtintorService inspecaoExtintorService;

    @PostMapping("/{numeroControleInterno}")
    public ResponseEntity<String> criarInspecao(@PathVariable int numeroControleInterno, @RequestBody InspecaoExtintor inspecaoExtintor) {
        inspecaoExtintorService.realizarInspecao(numeroControleInterno, inspecaoExtintor);
        return new ResponseEntity<>("Inspeção criada com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping("/{numeroControleInterno}")
    public ResponseEntity<InspecaoExtintor> obterInspecao(@PathVariable int numeroControleInterno) {
        InspecaoExtintor inspecaoExtintor = inspecaoExtintorService.obterPorNumeroControleInterno(numeroControleInterno);
        if (inspecaoExtintor != null) {
            return new ResponseEntity<>(inspecaoExtintor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{numeroControleInterno}")
    public ResponseEntity<String> atualizarInspecao(@PathVariable int numeroControleInterno, @RequestBody InspecaoExtintor inspecaoExtintor) {
        InspecaoExtintor inspecaoExtintorExistente = inspecaoExtintorService.obterPorNumeroControleInterno(numeroControleInterno);
        if (inspecaoExtintorExistente != null) {
            inspecaoExtintorService.atualizarInspecao(numeroControleInterno, inspecaoExtintor);
            return new ResponseEntity<>("Inspeção atualizada com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Inspeção não encontrada!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{numeroControleInterno}")
    public ResponseEntity<String> deletarInspecao(@PathVariable int numeroControleInterno) {
        InspecaoExtintor inspecaoExtintor = inspecaoExtintorService.obterPorNumeroControleInterno(numeroControleInterno);
        if (inspecaoExtintor != null) {
            inspecaoExtintorService.excluirInspecao(numeroControleInterno);
            return new ResponseEntity<>("Inspeção excluída com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Inspeção não encontrada!", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Collection<InspecaoExtintor>> obterTodos() {
        return new ResponseEntity<>(inspecaoExtintorService.obterTodos(), HttpStatus.OK);
    }
}

