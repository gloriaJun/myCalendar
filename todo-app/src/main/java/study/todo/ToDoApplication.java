package study.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import study.todo.core.domain.ToDo;
import study.todo.core.repository.ToDoRepository;


@SpringBootApplication
public class ToDoApplication {

    private static final Logger logger = LoggerFactory.getLogger(ToDoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ToDoApplication.class, args);
        logger.debug("Spring boot ToDoApplication Start~!!");
    }

    // set init data for testing
    @Bean
    public CommandLineRunner demo(ToDoRepository repository) {
        return (args) -> {
            repository.save(new ToDo("take a nap", true));
            repository.save(new ToDo("read a book", false));
            repository.save(new ToDo("go shopping", false));
            repository.save(new ToDo("wash a dishes", true));
        };
    }
}
