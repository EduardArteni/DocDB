package com.docdb.Entity;

public class User {
    private int id;
    private String username;
    private String password;
    private Status status;
    private AccountType accountType;

    enum Status{
        ONLINE,
        OFFLINE,
        DELETED,
        SUSPENDED
    }
    enum AccountType{
        DOCTOR,
        ASSISTANT,
        PATIENT
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
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
