package study.todo.service;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import study.todo.domain.ToDo;
import study.todo.repository.ToDoRepository;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToDoServiceTest {
    // 테스트를 하고자 하는 객체를 주입
    @Autowired
    private ToDoServiceImpl toDoService;

    // 테스트 대상에서 호출하는 객체를 mock으롯 ㅐ성
    @Mock
    private ToDoRepository toDoRepository;
    private ToDo toDo;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        toDo = new ToDo(1, "go jogging", true);
    }

    @Test
    public void testSave() {
        // 데이타 저장 시에 대한 기대 값을 정의
        when(toDoRepository.save(toDo)).thenReturn(toDo);

        //실제 테스트 하는 부분
        ToDo resultToDo = toDoService.save(toDo);
        assertNotNull(resultToDo);
        assertEquals(toDo, resultToDo);
        assertEquals(toDo.getText(), resultToDo.getText());
    }

    @Test
    public void testFindById() {
        // 데이타 저장 시에 대한 기대 값을 정의
        when(toDoRepository.findOne(toDo.getId())).thenReturn(toDo);

        ToDo resultToDo = toDoService.findOne(toDo.getId());
        assertNotNull(resultToDo);
        assertEquals(toDo, resultToDo);
    }

    @Test
    public void testFindByIdNotFound() {
        ToDo resultToDo = toDoService.findOne(0);
        assertNull(resultToDo);
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

    @Test
    public void testDelete() {
        // 데이타를 저장한다
        ToDo saveToDo = toDoService.save(toDo);
        assertThat(toDo.getId(), is(saveToDo.getId()));

        toDoService.delete(toDo.getId());
        assertNull(toDoService.findOne(toDo.getId()));
    }

    // verifyTest
    @Test
    public void verifyTest() {
        List<ToDo> toDoMock = mock(ArrayList.class);
        toDoMock.add(toDo);
        toDoMock.add(new ToDo(2, "bbb", true));

        // add()가 최소한 1번 이상 호출되었는지를 검증
        verify(toDoMock, atLeastOnce()).add(anyObject());
    }
}
