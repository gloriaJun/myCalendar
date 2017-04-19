package study.todo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
