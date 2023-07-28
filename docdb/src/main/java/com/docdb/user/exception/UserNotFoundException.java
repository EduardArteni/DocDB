package com.docdb.user.exception;

import com.docdb.common.web.NotFoundException;
import com.docdb.user.domain.User;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(Long id) {
        super(id, User.RESOURCE_NAME);
    }

    public UserNotFoundException(String email) {
        super(email, User.RESOURCE_NAME);
    }
}
