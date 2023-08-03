package com.docdb.user;

import com.docdb.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping(value = "/id")
    public User getUserById(@RequestParam(value = "id") Long id) {
        return service.getUserById(id);
    }

    @GetMapping(value = "/email")
    public User getUserByEmail(@RequestParam(value = "email") String email) {
        return service.findByEmail(email);
    }

    @GetMapping(value = "/username")
    public User getUserByUsername(@RequestParam(value = "username") String username) {
        return service.findByUsername(username);
    }

    @GetMapping(value = "/login")
    public User login(@RequestParam(value = "username") String username,
                      @RequestParam(value = "password") String password) {
        return service.login(username, password);
    }

    @PostMapping()
    public User signup(@RequestBody User user) {
        return service.createUser(user);
    }

    @DeleteMapping()
    public void deleteUserById(@RequestParam(value = "id") Long id) {
        service.removeUser(id);
    }

    @PutMapping()
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

}
