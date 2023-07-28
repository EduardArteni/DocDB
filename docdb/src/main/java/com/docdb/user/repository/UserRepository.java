package com.docdb.user.repository;


import com.docdb.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public record UserRepository(IUserRepository repository) {
    public User insert(User user) {
        if (user.getId() != null) {
            throw new IllegalArgumentException("Id provided");
        }
        return repository.save(user);
    }

    public User update(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("Null id provided");
        }
        return repository.save(user);
    }

    public void delete(User user) {
        repository.delete(user);
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public User findByEmail(String email){
        return repository.findByEmail(email);
    }
    public User findByUsername(String username){
        return repository.findByUsername(username);
    }

    //TODO add login method
}
