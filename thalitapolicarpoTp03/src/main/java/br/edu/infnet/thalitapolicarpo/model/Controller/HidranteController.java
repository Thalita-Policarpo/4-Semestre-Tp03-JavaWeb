package br.edu.infnet.thalitapolicarpo.model.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.infnet.thalitapolicarpo.model.domain.Hidrante;
import br.edu.infnet.thalitapolicarpo.model.service.HidranteService;

import java.util.Collection;

@RestController
@RequestMapping("/hidrantes")
public class HidranteController {

    @Autowired
    private HidranteService hidranteService;

    @PostMapping
    public ResponseEntity<String> incluirEquipamento(@RequestBody Hidrante hidrante) {
        hidranteService.incluirEquipamento(hidrante);
        return new ResponseEntity<>("Hidrante incluído com sucesso!", HttpStatus.CREATED);
    }

    @DeleteMapping("/{numeroControleInterno}")
    public ResponseEntity<String> excluirEquipamento(@PathVariable int numeroControleInterno) {
        hidranteService.excluirEquipamento(numeroControleInterno);
        return new ResponseEntity<>("Hidrante excluído com sucesso!", HttpStatus.OK);
    }

    @GetMapping("/{numeroControleInterno}")
    public ResponseEntity<Hidrante> obterPorNumeroControleInterno(@PathVariable int numeroControleInterno) {
        Hidrante hidrante = hidranteService.obterPorNumeroControleInterno(numeroControleInterno);
        return new ResponseEntity<>(hidrante, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<Hidrante>> obterTodos() {
        Collection<Hidrante> hidrantes = hidranteService.obterTodos();
        return new ResponseEntity<>(hidrantes, HttpStatus.OK);
    }
    
    @PutMapping("/{numeroControleInterno}")
    public ResponseEntity<String> atualizarEquipamento(@PathVariable int numeroControleInterno, @RequestBody Hidrante hidrante) {
        Hidrante hidranteExistente = hidranteService.obterPorNumeroControleInterno(numeroControleInterno);
        if (hidranteExistente != null) {
            hidranteService.excluirEquipamento(numeroControleInterno);
            hidranteService.incluirEquipamento(hidrante);
            return new ResponseEntity<>("Hidrante atualizado com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Hidrante não encontrado!", HttpStatus.NOT_FOUND);
        }
    }

}
