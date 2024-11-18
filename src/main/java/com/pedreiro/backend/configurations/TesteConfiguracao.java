package com.pedreiro.backend.configurations;
import com.pedreiro.backend.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("homologacao")
public class TesteConfiguracao {
    @Autowired
    DBService dbService;

    private boolean instanciar() {
        this.dbService.instanciarDB();
        return true;
    }
}
