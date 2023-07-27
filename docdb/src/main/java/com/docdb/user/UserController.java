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
//    @Autowired
//    private UserDAO userDAO = new UserDAO();

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getCuUserById(@RequestParam(value = "id") int id) throws SQLException {
        return userDAO.findUserById(id);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User signup(@RequestBody User user) throws SQLException {
        return UserDAO.createUser(user);
    }

    @RequestMapping(value = "/User", method = RequestMethod.POST)
    public User createUser(@RequestBody User User) throws SQLException {
        return UserDAO.createUser(User);
    }

    @RequestMapping(value = "/User", method = RequestMethod.DELETE)
    public void deleteUserById(@RequestParam(value = "id") int id) throws SQLException {
        UserDAO.deleteUser(id);
    }

    @RequestMapping(value = "/User", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user) throws SQLException {
        return UserDAO.updateUser(user);
    }

}
