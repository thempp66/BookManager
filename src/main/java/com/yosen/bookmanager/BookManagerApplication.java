package com.yosen.bookmanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BookManagerApplication {
    private static final Logger logger = LoggerFactory.getLogger(BookManagerApplication.class);

    public static void main(String[] args) {
        logger.info("Server start...");
        SpringApplication.run(BookManagerApplication.class, args);
    }

}


