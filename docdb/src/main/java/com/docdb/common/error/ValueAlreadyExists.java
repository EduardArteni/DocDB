package com.docdb.common.error;

public class ValueAlreadyExists extends RuntimeException {
    public ValueAlreadyExists(String message) {
        super(message);
    }
}
