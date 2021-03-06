package study.todo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import study.todo.ToDoApplication;
import study.todo.domain.ToDo;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = ToDoApplication.class)
public class ToDoControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext ctx;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testToDoList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/todo").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void testSaveToDo() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders
                    .post("/todo").accept(MediaType.APPLICATION_JSON_UTF8)
                    .content(objectMapper.writeValueAsString(new ToDo(1, "go shopping", false)))
                    )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(jsonPath("$.data.text").exists())
                .andDo(print());
    }
}
