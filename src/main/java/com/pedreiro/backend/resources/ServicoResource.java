package com.pedreiro.backend.resources;

import com.pedreiro.backend.entities.Servico;
import com.pedreiro.backend.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servico")
@CrossOrigin(origins = "http://localhost:4200")
public class ServicoResource {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<Servico> inserirServico(@RequestBody Servico servico) {
        Servico novoServico = servicoService.inserirServico(servico);
        return ResponseEntity.ok(novoServico);
    }

    @GetMapping
    public List<Servico> listarServicos() {
        return servicoService.listarServicos();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Servico> atualizarServico(@PathVariable Long id, @RequestBody Servico servico) {
        Optional<Servico> servicoAtualizado = servicoService.atualizarServico(id, servico);
        return servicoAtualizado.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarServico(@PathVariable Long id) {
        servicoService.deletarServico(id);
        return ResponseEntity.noContent().build();
    }
}