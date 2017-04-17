package study.todo.core.service;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import study.todo.core.domain.ToDo;
import study.todo.core.repository.ToDoRepository;
import study.todo.core.service.impl.ToDoServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ToDoServiceTest {
    @Mock
    private ToDoRepository toDoRepository;
    @InjectMocks
    private ToDoServiceImpl toDoService;
    // for test data
    private ToDo toDo = new ToDo(1, "go jogging", true);

    @Test
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {
        // 데이타 저장 시에 대한 기대 값을 정의
        when(toDoRepository.save(any(ToDo.class))).thenReturn(toDo);

        //실제 테스트 하는 부분
        ToDo resultToDo = toDoService.save(toDo);
        assertNotNull(resultToDo);
        assertEquals(toDo, resultToDo);
        assertEquals(toDo.getText(), resultToDo.getText());
    }

    @Test
    public void testFindById() {
        // 데이타 저장 시에 대한 기대 값을 정의
        when(toDoRepository.save(any(ToDo.class))).thenReturn(toDo);

        ToDo resultToDo = toDoService.findOne(toDo.getId());
        assertNotNull(resultToDo);
        assertEquals(toDo, resultToDo);
    }

    @Test
    public void testFindAll() {
        List<ToDo> toDoList = new ArrayList<ToDo>();
        toDoList.add(toDo);
        when(toDoRepository.findAll()).thenReturn(toDoList);

        List<ToDo> resultToDoList = toDoService.findAll();
        assertThat(resultToDoList, not(IsEmptyCollection.empty()));
        assertThat(resultToDoList, is(toDoList));
        assertThat(resultToDoList.size(), is(toDoList.size()));
    }
}
