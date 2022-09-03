package com.pedrobritto.workshopmongo.resource;

import com.pedrobritto.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Pedro Britto", "pedro@gmail.com");
        User alex = new User("2", "Alex Costa", "alex@gmail.com");
        return ResponseEntity.ok(new ArrayList<>(Arrays.asList(maria, alex)));
    }
}