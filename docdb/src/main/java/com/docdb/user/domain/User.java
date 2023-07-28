package com.docdb.user.domain;

import com.docdb.user.dto.AccountType;
import com.docdb.user.dto.Status;
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
    public static final String RESOURCE_NAME = "user";

    @Id
    @SequenceGenerator(
            name = "users_id_seq",
            sequenceName = "users_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_id_seq"
    )
    private Long id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
