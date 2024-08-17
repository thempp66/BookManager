package com.yosen.bookmanager.controller;

import com.yosen.bookmanager.model.Book;
import com.yosen.bookmanager.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/book")
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        Book book =bookService.getBookById(id);
        logger.debug("url={}, method={}, id={}, book={}, state={}", "/api/book", "query", id, book, "succ");
        return book;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        logger.debug("url={}, method={}, book={}, state={}", "/api/book", "create", book, "succ");
        return bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setIsbn(bookDetails.getIsbn());
            logger.debug("url={}, method={}, book={}, state={}", "/api/book", "update", book, "succ");
            return bookService.saveBook(book);
        }
        logger.debug("url={}, method={}, book={}, state={}", "/api/book", "update", book, "fail");
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        logger.debug("url={}, method={}, id={}, state={}", "/api/book", "update", id, "succ");
    }
}