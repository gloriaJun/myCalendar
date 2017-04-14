package study.todo.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.todo.core.domain.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
