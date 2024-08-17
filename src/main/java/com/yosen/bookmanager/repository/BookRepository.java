package com.yosen.bookmanager.repository;

import com.yosen.bookmanager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}