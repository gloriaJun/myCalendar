package study.todo.web.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import study.todo.core.domain.ToDo;
import study.common.web.model.ApiResult;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    private static final Logger logger = LoggerFactory.getLogger(ToDoController.class);

    @ApiOperation(value = "Get ToDo List")
    @GetMapping
    public HttpEntity<List<ToDo>> getToDoList() {
        List<ToDo> toDoList = new ArrayList<ToDo>();

        ToDo toDo = new ToDo(1, "aaa", false);
        toDo.add(linkTo(methodOn(ToDoController.class).getToDoList()).withSelfRel());
        toDoList.add(toDo);

        return new ResponseEntity<List<ToDo>>(toDoList, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<ToDo> saveToDo(ToDo toDo) {
        return new ResponseEntity<ToDo>(toDo, HttpStatus.OK);
    }

    @ApiOperation(value = "Get ToDo List")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "todo Id", required = true, paramType = "path")
    )
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Id")
    })
    @PutMapping("/{id}")
    public ApiResult<ToDo> updateToDo(@PathVariable long id) {
        ToDo toDo = new ToDo();
        return new ApiResult<>(toDo);
    }

    @DeleteMapping("/{id}")
    public ApiResult deleteToDo(@PathVariable long id) {

        return new ApiResult();
    }
}
