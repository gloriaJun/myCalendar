package study.todo.core.domain;

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
    String text;
    boolean completed;
}
