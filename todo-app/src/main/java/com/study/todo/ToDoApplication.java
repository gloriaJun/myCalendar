package com.study.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ToDoApplication {

    private static final Logger logger = LoggerFactory.getLogger(ToDoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ToDoApplication.class, args);
        logger.debug("Spring boot ToDoApplication Start~!!");
    }
}
