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

/**
 * 할 일 목록 관리를 위한 컨트롤러
 */
@RestController
@RequestMapping("/todo")
public class ToDoController {

    private static final Logger logger = LoggerFactory.getLogger(ToDoController.class);

    private ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    /**
     * 저장된 전체 리스트를 조회한다
     * @return
     */
    @ApiOperation(value = "Get ToDo List")
    @GetMapping
    public ResponseEntity<List<ToDo>> getToDoList() {
        return new ResponseEntity<List<ToDo>>(toDoService.findAll(), HttpStatus.OK);
    }

    /**
     * 새로운 할일을 등록한다
     * @param toDo
     * @return
     */
    @ApiOperation(value = "Save New ToDo")
    @PostMapping
    public HttpEntity<ToDo> saveToDo(ToDo toDo) {
        return new ResponseEntity<>(toDoService.save(toDo), HttpStatus.OK);
    }

    /**
     * Id에 해당하는 할일을 수정한다
     * @param id
     * @param toDo
     * @return
     */
    @ApiOperation(value = "Modify ToDo by ID")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "todo Id", required = true, paramType = "path")
    )
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid ID")
    })
    @PutMapping("/{id}")
    public HttpEntity<ToDo> updateToDo(@PathVariable long id, ToDo toDo) {
        return new ResponseEntity<>(toDoService.update(toDo), HttpStatus.OK);
    }

    /**
     * Id에 해당하는 할일을 조회한다
     * @param id
     * @return
     */
    @ApiOperation(value = "Find ToDo by ID")
    @GetMapping("/{id}")
    public HttpEntity<ToDo> findToDobyId(@PathVariable long id) {
        return new ResponseEntity<ToDo>(toDoService.findOne(id), HttpStatus.OK);
    }

    /**
     * Id에 해당하는 할일을 삭제한다
     * @param id
     * @return
     */
    @ApiOperation(value = "Delete ToDo by ID")
    @DeleteMapping("/{id}")
    public HttpEntity deleteToDo(@PathVariable long id) {
        toDoService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}