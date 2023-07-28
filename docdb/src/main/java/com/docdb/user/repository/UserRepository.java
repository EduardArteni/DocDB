package com.docdb.user.repository;


import com.docdb.user.domain.User;
import org.springframework.data.jpa.repository.Query;
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

//    @Query("SELECT u FROM users u WHERE u.email = 1")
//    public Optional<User> findByEmail(String email){
//        return null;
//
//    }

    //TODO add login method
}
