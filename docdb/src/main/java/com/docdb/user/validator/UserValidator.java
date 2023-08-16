package com.docdb.user.validator;

import com.docdb.common.error.InvalidArgumentException;

public class UserValidator {

    public static void verifyEmail(String email) {
        if (!email.contains("@")) throw new InvalidArgumentException("email invalid");
    }

    public static void verifyPassword(String password) {
        if (password.length() < 5) throw new InvalidArgumentException("password invalid");
    }
}
