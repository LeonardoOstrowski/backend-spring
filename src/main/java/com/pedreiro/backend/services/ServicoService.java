package com.pedreiro.backend.services;

import com.pedreiro.backend.entities.Servico;
import com.pedreiro.backend.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public Servico inserirServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    public List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }

    public Optional<Servico> atualizarServico(Long id, Servico servicoAtualizado) {
        return servicoRepository.findById(id).map(servico -> {
            servico.setDescricao(servicoAtualizado.getDescricao());
            servico.setData(servicoAtualizado.getData());
            servico.setCusto(servicoAtualizado.getCusto());
            return servicoRepository.save(servico);
        });
    }

    public void deletarServico(Long id) {
        servicoRepository.deleteById(id);
    }
}
