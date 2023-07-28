package com.docdb.user;

import com.docdb.user.domain.User;
import com.docdb.user.exception.InvalidEmailException;
import com.docdb.user.exception.UserNotFoundException;
import com.docdb.user.repository.UserRepository;
import static com.docdb.user.validator.UserValidator.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User createUser(User user) {
        verifyEmail(user.getEmail());
        verifyPassword(user.getPassword());

        //unique email
        //unique username

        return repository.insert(user);
    }

    User findByEmail(String email){
        return repository.repository().findByEmail(email);
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
