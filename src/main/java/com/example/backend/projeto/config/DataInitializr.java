package com.example.backend.projeto.config;

import com.example.backend.projeto.entity.User;
import com.example.backend.projeto.repository.UserRepository;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<User> userList = userRepository.findAll();

        if(userList.isEmpty()){
            createUser("Maria","maria@email.com","12345");
            createUser("João","maria@email.com","12345");
            createUser("José","maria@email.com","12345");
            createUser("Ricardo","maria@email.com","12345");
            createUser("Fernanda","maria@email.com","12345");
        }
    }


    public void createUser(String name,String email,String password){
        User user = new User(name,email,password);
        userRepository.save(user);
    }

}
