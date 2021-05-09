package com.example.backend.projeto.controller;

import com.example.backend.projeto.entity.User;
import com.example.backend.projeto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> list(){

     return  userRepository.findAll();
    }

    /*
    * Retorna a lista de usuário paginada
    * */
    @GetMapping("/paginado")
    public Page<User> list(
            @RequestParam("page") int page,
            @RequestParam("size") int size

    ){
        Pageable pageable = PageRequest.of(page,size);

        return  userRepository.findAll(pageable);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody  User user) {
        return userRepository.save(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody  User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> userById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

}
