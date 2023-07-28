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

    public void delete(User user){
        repository.delete(user);
    }

    //TODO handle user not found exception
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    //TODO add login method
}
