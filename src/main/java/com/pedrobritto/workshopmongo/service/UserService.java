package com.pedrobritto.workshopmongo.service;

import com.pedrobritto.workshopmongo.domain.User;
import com.pedrobritto.workshopmongo.dto.UserDTO;
import com.pedrobritto.workshopmongo.repository.UserRepository;
import com.pedrobritto.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj) {
        Optional<User> newObj = repository.findById(obj.getId());
        var user1 = new User();
        if(newObj.isPresent()) {
            user1 = newObj.get();
        }
        updateData(user1, obj);
        return repository.save(user1);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
