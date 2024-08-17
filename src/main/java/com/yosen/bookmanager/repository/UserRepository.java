package com.yosen.bookmanager.repository;

import com.yosen.bookmanager.model.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<BookUser, Long> {
    Optional<BookUser> findByUsername(String username);
}
