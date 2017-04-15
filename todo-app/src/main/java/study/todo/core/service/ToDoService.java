package study.todo.core.service;

import study.todo.core.domain.ToDo;

import java.util.List;

public interface ToDoService {
    public ToDo save(ToDo toDo);
    public ToDo update(ToDo toDo);
    public List<ToDo> findAll();
    public ToDo findOne(long id);
    public void delete(long id);
}
