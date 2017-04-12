package com.study.todo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @GetMapping
    public String getToDoList() {
        return "test";
    }

    @PostMapping
    public String saveToDo() {
        return "test";
    }

    @PutMapping("/{id}")
    public String updateToDo(@PathVariable long id) {
        return "update : " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteToDo(@PathVariable long id) {
        return "delete : " + id;
    }
}
