package com.docdb.user.exception;

import com.docdb.common.dto.ErrorCode;
import com.docdb.common.web.BusinessException;

import javax.naming.directory.InvalidAttributesException;

public class InvalidEmailException extends BusinessException {
    public InvalidEmailException(String resourceName) {
        super(ErrorCode.BAD_REQUEST_DATA, String.format("Invalid email address %s.", resourceName));
    }

}