package study.todo.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.todo.core.domain.ToDo;
import study.todo.core.repository.ToDoRepository;
import study.todo.core.service.ToDoService;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public ToDo update(ToDo toDo) {
        return null;
    }

    @Override
    public List<ToDo> findAll() {
        return (List<ToDo>)toDoRepository.findAll();
    }

    @Override
    public ToDo findOne(long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
