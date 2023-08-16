package com.docdb.user;

import com.docdb.user.domain.User;
import com.docdb.common.error.IdNotProvided;
import com.docdb.common.error.IdProvided;
import com.docdb.user.exception.UserNotFoundException;
import com.docdb.common.error.ValueAlreadyExists;
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
        if (user.getId() != null)
            throw new IdProvided("id provided");
        verifyEmail(user.getEmail());
        verifyPassword(user.getPassword());
        if (repository.findByEmail(user.getEmail()).isPresent())
            throw new ValueAlreadyExists("Email already in use.");
        if (repository.findByUsername(user.getUsername()).isPresent())
            throw new ValueAlreadyExists("Username already in use.");

        return repository.save(user);
    }

    User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("user not found for given email"));
    }

    User findByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("user not found for given username"));
    }

    User login(String username, String password) {
        return repository.findByUsernameAndPassword(username, password).orElseThrow(() -> new UserNotFoundException("username or password wrong"));
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("user not found for given id"));
    }

    public void removeUser(Long id) {
        User user = getUserById(id);
        repository.delete(user);
    }

    public User updateUser(User user) {
        if (user.getId() == null) throw new IdNotProvided("id not provided");
        return repository.save(user);
    }

}
