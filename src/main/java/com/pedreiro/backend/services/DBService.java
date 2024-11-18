package com.pedreiro.backend.services;

import com.pedreiro.backend.entities.Cliente;
import com.pedreiro.backend.entities.Servico;
import com.pedreiro.backend.entities.Usuario;
import com.pedreiro.backend.repositories.ClienteRepository;
import com.pedreiro.backend.repositories.ServicoRepository;
import com.pedreiro.backend.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void instanciarDB() {
        Cliente cliente1 = new Cliente("Gabriel", "Rua das Flores, 123, Centro", "11987654321", "99118524079", 1L);
        Cliente cliente2 = new Cliente("Guilherme", "Rua B, 456", "119787654321", "74776443058", 2L);

        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));

        Servico servico1 = new Servico("Construção de parede e reparos em alvenaria", "10/11/2014", 750.0);
        Servico servico2 = new Servico("Demolição", "04/11/2024", 1700.0);

        servicoRepository.saveAll(Arrays.asList(servico1, servico2));

        Usuario admin = new Usuario("admin", "admin");
        userRepository.save(admin);
    }
}
