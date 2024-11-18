package com.pedreiro.backend.resources;

import com.pedreiro.backend.entities.Usuario;
import com.pedreiro.backend.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginResource {

    @Autowired
    private LoginService authService;

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginRequest request) {
        Optional<Usuario> user = authService.login(request.getName(), request.getPassword());
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }

    // Corpo da requisição
    public static class LoginRequest {
        private String name;
        private String password;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}