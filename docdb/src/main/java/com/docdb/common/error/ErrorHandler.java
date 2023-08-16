package com.docdb.common.error;

import com.docdb.user.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseDTO> handleUserNotFoundException(UserNotFoundException e) {
        ErrorResponseDTO body = new ErrorResponseDTO(NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(NOT_FOUND).body(body);
    }

    @ExceptionHandler(IdNotProvided.class)
    public ResponseEntity<ErrorResponseDTO> handleIdNotProvided(IdNotProvided e) {
        ErrorResponseDTO body = new ErrorResponseDTO(BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(BAD_REQUEST).body(body);
    }

    @ExceptionHandler(IdProvided.class)
    public ResponseEntity<ErrorResponseDTO> handleIdProvided(IdProvided e) {
        ErrorResponseDTO body = new ErrorResponseDTO(BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(BAD_REQUEST).body(body);
    }

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidArgumentException(InvalidArgumentException e) {
        ErrorResponseDTO body = new ErrorResponseDTO(BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ValueAlreadyExists.class)
    public ResponseEntity<ErrorResponseDTO> handleValueAlreadyExists(ValueAlreadyExists e) {
        ErrorResponseDTO body = new ErrorResponseDTO(CONFLICT.value(), e.getMessage());
        return ResponseEntity.status(CONFLICT).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception e) {
        ErrorResponseDTO body = new ErrorResponseDTO(INTERNAL_SERVER_ERROR.value(), e.getMessage());
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(body);
    }
}
