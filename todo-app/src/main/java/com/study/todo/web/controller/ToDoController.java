package com.study.todo.web.controller;

import com.study.todo.core.domain.ToDos;
import com.study.common.web.model.ApiResult;
import io.swagger.annotations.*;
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
    public ApiResult<List<ToDos>> getToDoList() {
        List<ToDos> toDosList = new ArrayList<ToDos>();
        return new ApiResult<>(toDosList);
    }

    @PostMapping
    public ApiResult<ToDos> saveToDo() {
        ToDos toDos = new ToDos();
        return new ApiResult<>(toDos);
    }

    @ApiOperation(value = "Get ToDo List")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "todo Id", required = true, paramType = "path")
    )
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Id")
    })
    @PutMapping("/{id}")
    public ApiResult<ToDos> updateToDo(@PathVariable long id) {
        ToDos toDos = new ToDos();
        return new ApiResult<>(toDos);
    }

    @DeleteMapping("/{id}")
    public ApiResult deleteToDo(@PathVariable long id) {

        return new ApiResult();
    }
}
