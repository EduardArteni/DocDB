package com.docdb.user;

public class User {
    private long id;
    private String username;
    private String password;
    private Status status;
    private AccountType accountType;

    public enum Status{
        ACTIVE,
        DELETED,
        SUSPENDED
    }
    public enum AccountType{
        DOCTOR,
        ASSISTANT,
        PATIENT
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }


    public AccountType getAccountType() {
        return accountType;
    }
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
