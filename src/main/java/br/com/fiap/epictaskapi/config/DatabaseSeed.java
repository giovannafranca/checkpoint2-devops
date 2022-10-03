package br.com.fiap.epictaskapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.epictaskapi.model.Task;
import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.repository.TaskRepository;
import br.com.fiap.epictaskapi.repository.UserRepository;

@Configuration
public class DatabaseSeed implements CommandLineRunner {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        
        taskRepository.saveAll(List.of(
            new Task("Modelar o BD", "Modelar as tabelas do banco de dados"),
            new Task("Protipar telas", "Modelar as tabelas do banco de dados"),
            new Task("Bug", "Modelar as tabelas do banco de dados"),
            new Task("Deploy", "Modelar as tabelas do banco de dados"),
            new Task("Login", "Modelar as tabelas do banco de dados"),
            new Task("Outro Bug", "Modelar as tabelas do banco de dados"),
            new Task("Logout", "Modelar as tabelas do banco de dados"),
            new Task("Cadastro de cliente", "Modelar as tabelas do banco de dados"),
            new Task("Consulta de cliente", "Modelar as tabelas do banco de dados")
        ));

        userRepository.save(
            new User()
                .name("João")
                .email("joao@fiap.com.br")
                .password(passwordEncoder.encode("123"))
        );
        
    }
    
}
