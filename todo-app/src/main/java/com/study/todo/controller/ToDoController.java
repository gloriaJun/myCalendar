package com.study.todo.controller;

import com.study.todo.model.ToDos;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    private static final Logger logger = LoggerFactory.getLogger(ToDoController.class);

    @ApiOperation(value = "Get ToDo List")
    @GetMapping
    public List<ToDos> getToDoList() {
        List<ToDos> toDosList = new ArrayList<ToDos>();
        return toDosList;
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
