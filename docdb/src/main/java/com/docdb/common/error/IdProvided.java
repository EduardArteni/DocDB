package com.docdb.common.error;

public class IdProvided extends RuntimeException {
    public IdProvided(String message) {
        super(message);
    }
}
