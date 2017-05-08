package study.todo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {
    @Id
    @GeneratedValue
    long id;
//    @NotNull
    String text;
    boolean completed;

    public ToDo(String text, boolean completed) {
        this.text = text;
        this.completed = completed;
    }
}
