package com.docdb.user;

import com.docdb.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping(value = "/id")
    public ResponseEntity<User> getUserById(@RequestParam(value = "id") Long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @GetMapping(value = "/email")
    public ResponseEntity<User> getUserByEmail(@RequestParam(value = "email") String email) {
        return ResponseEntity.ok(service.findByEmail(email));
    }

    @GetMapping(value = "/username")
    public ResponseEntity<User> getUserByUsername(@RequestParam(value = "username") String username) {
        return ResponseEntity.ok(service.findByUsername(username));
    }

    @GetMapping(value = "/login")
    public ResponseEntity<User> login(@RequestParam(value = "identifier") String identifier,
                                      @RequestParam(value = "password") String password) {
        return ResponseEntity.ok(service.login(identifier, password));
    }

    @PostMapping()
    public ResponseEntity<User> signup(@RequestBody User user) {
        return ResponseEntity.ok(service.createUser(user));
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteUserById(@RequestParam(value = "id") Long id) {
        service.removeUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(service.updateUser(user));
    }

}
