package study.todo.core.repository;

import org.springframework.data.repository.CrudRepository;
import study.todo.core.domain.ToDo;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {
}
