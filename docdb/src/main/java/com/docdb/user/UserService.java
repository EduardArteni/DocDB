package com.docdb.user;

import com.docdb.user.domain.User;
import com.docdb.user.exception.UserNotFoundException;
import com.docdb.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.docdb.user.validator.UserValidator.verifyEmail;
import static com.docdb.user.validator.UserValidator.verifyPassword;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User createUser(User user) {
        verifyEmail(user.getEmail());
        verifyPassword(user.getPassword());
        if(findByEmail(user.getEmail()) != null) throw new RuntimeException("Email already in use.");
        if (findByUsername(user.getUsername()) != null) throw new RuntimeException("Username already in use.");

        return repository.insert(user);
    }

    User findByEmail(String email){
        return repository.findByEmail(email);
    }
    User findByUsername(String username){
        return repository.findByUsername(username);
    }
    User login(String username, String password){
        return repository.login(username, password);
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElseGet(() -> {
            log.warn("user not found for id {}", id);
            throw new UserNotFoundException(id);
        });
    }

    public void removeUser(Long id) {
        User user = getUserById(id);
        repository.delete(user);
    }

    public User updateUser(User user) {
        return repository.update(user);
    }

}
