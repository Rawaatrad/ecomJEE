package jee.projet.ecom.service;

import jee.projet.ecom.Repository.UserRepository;
import jee.projet.ecom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;


    public Optional<User> findByEmailAndPassword(String email, String password){
        return repository.findByEmailAndPassword(email,password);

    }


}
