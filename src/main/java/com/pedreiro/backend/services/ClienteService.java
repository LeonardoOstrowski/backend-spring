package com.pedreiro.backend.services;

import com.pedreiro.backend.entities.Cliente;
import com.pedreiro.backend.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente inserirCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> atualizarCliente(Long id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setServicoId(clienteAtualizado.getServicoId());
            cliente.setEndereco(clienteAtualizado.getEndereco());
            cliente.setTelefone(clienteAtualizado.getTelefone());
            cliente.setCpf(clienteAtualizado.getCpf());
            return clienteRepository.save(cliente);
        });
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
