package com.example.backend.projeto.config;

import com.example.backend.projeto.entity.Role;
import com.example.backend.projeto.entity.User;
import com.example.backend.projeto.repository.RoleRepository;
import com.example.backend.projeto.repository.UserRepository;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<User> userList = userRepository.findAll();

        if(userList.isEmpty()){
            createUser("Maria","admin",passwordEncoder.encode("12345"),"ROLE_ADMIN");
            createUser("João","joao@email.com",passwordEncoder.encode("12345"),"ROLE_DEVELOPER");
            createUser("José","jose@email.com",passwordEncoder.encode("12345"),"ROLE_DEVELOPER");
            createUser("Ricardo","ricardo@email.com",passwordEncoder.encode("12345"),"ROLE_DEVELOPER");
            createUser("Fernanda","fernanda@email.com",passwordEncoder.encode("12345"),"ROLE_DEVELOPER");
        }
    }


    public void createUser(String name,String email,String password,String role){
        Role roleObj = new Role();
        roleObj.setName(role);
        roleRepository.save(roleObj);


        User user = new User(name,email,password, Arrays.asList(roleObj));
        userRepository.save(user);
    }

}
