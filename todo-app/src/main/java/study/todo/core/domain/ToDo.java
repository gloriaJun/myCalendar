package study.todo.core.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;


@Data
@Getter
@Setter
public class ToDo extends ResourceSupport{
    long todoId;
    String text;
    boolean completed;

    public ToDo() {}
    public ToDo(long todoId, String text, boolean completed) {
        this.todoId = todoId;
        this.text = text;
        this.completed = completed;
    }
}
