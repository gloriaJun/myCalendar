package study.todo.service;

import org.springframework.stereotype.Service;
import study.todo.domain.ToDo;

import java.util.List;

@Service
public interface ToDoService {
    /**
     * 새로운 toDo를 저장한다
     * @param toDo
     * @return toDo
     */
    public ToDo save(ToDo toDo);

    /**
     * id에 해당하는 toDo를 수정한다
     * @param toDo
     * @return toDo
     */
    public ToDo update(ToDo toDo);

    /**
     * 저장된 toDo 목록을 전달한다
     * @return
     */
    public List<ToDo> findAll();

    /**
     * id에 해당하는 toDo를 전달한다
     * @param id
     * @return toDo
     */
    public ToDo findOne(long id);

    /**
     * id에 해당하는 toDo를 삭제한다
     * @param id
     */
    public void delete(long id);
}
