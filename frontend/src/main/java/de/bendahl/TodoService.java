package de.bendahl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * This service handles all REST api calls to the backend.
 *
 * @author Benjamin Dahlmanns
 */
@Component
public class TodoService {

    private final String backendUrl;

    @Autowired
    public TodoService(@Value("${todo.backend.url}") String backendUrl) {
        this.backendUrl = backendUrl;
    }

    List<Todo> getAllTodos() {
        RestTemplate template = new RestTemplate();
        Todo[] todos = template.getForObject(backendUrl, Todo[].class);
        return Arrays.asList(todos);
    }

    void save(Todo todo) {
        if(todo.getText() == null || todo.getText().isEmpty()) {
            return;
        }
        RestTemplate template = new RestTemplate();
        template.postForObject(backendUrl + "/todo", todo, Todo.class);
    }

    void deleteByDone(boolean done) {
        RestTemplate template = new RestTemplate();
        template.delete(backendUrl + "?done=" + done);
    }

    void change(Todo todo) {
        if(todo.getText() == null || todo.getText().isEmpty()) {
            return;
        }
        RestTemplate template = new RestTemplate();
        template.put(backendUrl + "/todo/" + todo.getId(), todo);
    }
}
