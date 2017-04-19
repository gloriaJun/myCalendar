package study.todo.repository;

import org.springframework.data.repository.CrudRepository;
import study.todo.domain.ToDo;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {
}
