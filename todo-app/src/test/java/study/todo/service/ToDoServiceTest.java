package study.todo.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

import study.todo.domain.ToDo;
import study.todo.repository.ToDoRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class ToDoServiceTest {

    private Logger logger = LoggerFactory.getLogger(ToDoServiceTest.class);

    // 테스트 대상에서 호출하는 객체를 mock으롯 ㅐ성
    @Mock
    private ToDoRepository toDoRepository;
    // 테스트를 하고자 하는 객체를 주입
    @InjectMocks
    private ToDoServiceImpl toDoService;
    private ToDo toDo;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        toDo = new ToDo(1, "go jogging", true);
    }

    @Test
    public void testFindById() {
        //--------------------
        // given
        // 데이타 저장 시에 대한 기대 값을 정의
        when(toDoRepository.findOne(toDo.getId())).thenReturn(toDo);

        //------------
        // when
        ToDo result = toDoService.findOne(toDo.getId());
        logger.debug(result.toString());

        //------------
        // then
        verify(toDoRepository, times(1)).findOne(toDo.getId());
        assertThat(result, is(notNullValue()));
        assertThat(result, is(toDo));
        assertThat(result.getText(), is(toDo.getText()));
    }

    @Test
    public void testFindByIdNotFound() {
        long id = 0L;
        when(toDoRepository.findOne(id)).thenReturn(null);
        ToDo result = toDoService.findOne(id);
        verify(toDoRepository, times(1)).findOne(id);
        assertThat(result, is(nullValue()));
    }

    @Test
    public void testSave() {
        // 데이타 저장 시에 대한 기대 값을 정의
        when(toDoRepository.save(toDo)).thenReturn(toDo);
        //실제 테스트 하는 부분
        ToDo result = toDoService.save(toDo);
        verify(toDoRepository, times(1)).save(toDo);
    }

    @Test
    public void testFindAll() {
        List<ToDo> toDoList = new ArrayList<ToDo>();
        toDoList.add(toDo);
        toDoList.add(new ToDo("take a nap", true));
        toDoList.add(new ToDo("read a book", false));
        toDoList.add(new ToDo("wash a dishes", true));
        when(toDoRepository.findAll()).thenReturn(toDoList);

        List<ToDo> resultList = toDoService.findAll();
        verify(toDoRepository, times(1)).findAll();
        assertThat(resultList, is(notNullValue()));
        assertThat(resultList, hasSize(4));
    }

    @Test
    public void testDelete() {
//        when(toDoRepository.delete(toDo.getId())).thenReturn(null);
//
//        toDoService.delete(toDo.getId());
////        assertNull(toDoService.findOne(toDo.getId()));
//        verify(toDoRepository, times(1)).delete(toDo.getId());
    }
}
