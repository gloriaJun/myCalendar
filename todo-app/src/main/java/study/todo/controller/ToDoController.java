package study.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import study.todo.domain.ToDo;
import study.common.web.model.ApiResult;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import study.todo.service.ToDoService;

import java.util.List;


@RestController
@RequestMapping("/todo")
public class ToDoController {

    private static final Logger logger = LoggerFactory.getLogger(ToDoController.class);

    private ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @ApiOperation(value = "Get ToDo List")
    @GetMapping
    public ResponseEntity<List<ToDo>> getToDoList() {
        return new ResponseEntity<List<ToDo>>(toDoService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<ToDo> saveToDo(ToDo toDo) {
        return new ResponseEntity<ToDo>(toDoService.save(toDo), HttpStatus.OK);
    }

    @ApiOperation(value = "Get ToDo List")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "todo Id", required = true, paramType = "path")
    )
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Id")
    })
    @PutMapping("/{id}")
    public ApiResult<ToDo> updateToDo(@PathVariable long id, ToDo toDo) {
        return new ApiResult<>(toDoService.update(toDo));
    }

    @DeleteMapping("/{id}")
    public ApiResult deleteToDo(@PathVariable long id) {

        return new ApiResult();
    }
}
