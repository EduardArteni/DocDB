package com.docdb.user.repository;

import com.docdb.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
