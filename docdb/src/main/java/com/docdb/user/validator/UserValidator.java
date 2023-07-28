package com.docdb.user.validator;

import com.docdb.user.domain.User;
import com.docdb.user.exception.InvalidEmailException;
import com.docdb.user.exception.InvalidPasswordException;

import java.lang.reflect.Executable;

public class UserValidator {

    public static void verifyEmail(String email) {
        if (!email.contains("@")) throw new InvalidEmailException(email);
//        if (getUserByEmail(email) != null) throw new InvalidEmailException(email);
    }

    public static void verifyPassword(String password) {
        if (password.length() < 5) throw new InvalidPasswordException(password);
    }
}
