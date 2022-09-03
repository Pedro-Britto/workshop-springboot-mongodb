package com.pedrobritto.workshopmongo.service;

import com.pedrobritto.workshopmongo.domain.User;
import com.pedrobritto.workshopmongo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();

    }
}
