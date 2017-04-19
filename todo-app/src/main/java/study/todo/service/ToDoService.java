package study.todo.service;

import org.springframework.stereotype.Service;
import study.todo.domain.ToDo;

import java.util.List;

@Service
public interface ToDoService {
    public ToDo save(ToDo toDo);
    public ToDo update(ToDo toDo);
    public List<ToDo> findAll();
    public ToDo findOne(long id);
    public void delete(long id);
}
