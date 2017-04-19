package study.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.todo.domain.ToDo;
import study.todo.repository.ToDoRepository;

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
        return toDoRepository.save(toDo);
    }

    @Override
    public List<ToDo> findAll() {
        return (List<ToDo>)toDoRepository.findAll();
    }

    @Override
    public ToDo findOne(long id) {
        return toDoRepository.findOne(id);
    }

    @Override
    public void delete(long id) {

    }
}
