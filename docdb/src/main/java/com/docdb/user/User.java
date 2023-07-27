package com.docdb.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
