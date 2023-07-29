package com.docdb.user.repository;

import com.docdb.user.domain.User;
import com.docdb.user.dto.AccountType;
import com.docdb.user.dto.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);

    List<User> findByStatusAndAccountType(Status status, AccountType accountType );
}
