package com.docdb.user;

import com.docdb.user.UserDAO;
import com.docdb.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getCuUserById(@RequestParam(value = "id") int id) throws SQLException {
        return userDAO.findUserById(id);
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User signup(@RequestBody User user) throws SQLException {
        return userDAO.createUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public void deleteUserById(@RequestParam(value = "id") int id) throws SQLException {
        userDAO.deleteUser(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user) throws SQLException {
        return userDAO.updateUser(user);
    }

}
