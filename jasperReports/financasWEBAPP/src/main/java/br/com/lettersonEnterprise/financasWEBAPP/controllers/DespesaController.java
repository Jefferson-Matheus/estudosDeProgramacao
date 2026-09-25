package br.com.lettersonEnterprise.financasWEBAPP.controllers;

import br.com.lettersonEnterprise.financasWEBAPP.dtos.DespesaDTORecord;
import br.com.lettersonEnterprise.financasWEBAPP.dtos.DespesaDTORespostaRecord;
import br.com.lettersonEnterprise.financasWEBAPP.dtos.DespesaRequestDTO;
import br.com.lettersonEnterprise.financasWEBAPP.entities.Despesa;
import br.com.lettersonEnterprise.financasWEBAPP.services.DespesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/despesas")
public class DespesaController {

    private final DespesaService despesaService;

    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    @PostMapping
    public ResponseEntity<DespesaDTORespostaRecord> cadastrar(@RequestBody DespesaDTORecord despesa) {
        DespesaDTORespostaRecord despesaCriada = despesaService.cadastrarDespesa(despesa);
        return ResponseEntity.status(HttpStatus.CREATED).body(despesaCriada);
    }

    @GetMapping
    public ResponseEntity<List<DespesaDTORespostaRecord>> listarTodas() {
        List<DespesaDTORespostaRecord> todasDepesas = despesaService.listarTodasDespesar();
        return ResponseEntity.ok(todasDepesas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDespesa(@PathVariable Long id) {
        boolean despesaEncontrada = despesaService.deletarDespesa(id);

        if(!despesaEncontrada) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DespesaDTORespostaRecord> atualizar(@PathVariable Long id, @RequestBody DespesaDTORecord despesaAtualizada) {
        boolean sucesso = despesaService.atualizarDespesa(id, despesaAtualizada.descricao(), despesaAtualizada.precoDespesa());

        if(!sucesso) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        DespesaDTORespostaRecord despesaNova = new DespesaDTORespostaRecord(id,despesaAtualizada.descricao(), despesaAtualizada.precoDespesa());
        return ResponseEntity.ok(despesaNova);
    }
}
