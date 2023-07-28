package com.docdb.user.exception;

import com.docdb.common.dto.ErrorCode;
import com.docdb.common.web.BusinessException;
import com.docdb.user.domain.User;
import jdk.jshell.spi.ExecutionControl;

public class InvalidPasswordException extends BusinessException {
    public InvalidPasswordException(String password) {
        super(ErrorCode.BAD_REQUEST_DATA, String.format("%s with id %s was not found", password));
    }

}
