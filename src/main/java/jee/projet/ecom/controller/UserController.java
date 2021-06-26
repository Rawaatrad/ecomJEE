package jee.projet.ecom.controller;

import jee.projet.ecom.entity.User;
import jee.projet.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/user")
    public Optional<User> login(@RequestBody User user) throws Exception{
       Optional<User> useer = service.findByEmailAndPassword(user.getEmail(), user.getPassword());
       if(useer.isPresent()){
           return useer;
       }
       else throw new Exception("bad credentials");


    }

}
