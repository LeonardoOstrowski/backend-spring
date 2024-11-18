package com.pedreiro.backend.services;

import com.pedreiro.backend.entities.Usuario;
import com.pedreiro.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public Optional<Usuario> login(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);
    }
}