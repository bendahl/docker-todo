package de.bendahl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * This is the REST endpoint of the application. Swagger annotations are used to add some meta data
 * to the class. This is then used by Swagger to generate additional documentation.
 *
 * @author Benjamin Dahlmanns
 */
@Api("Awesome little todo application to demonstrate Docker")
@RestController
@RequestMapping("/todos")
public class TodoEndpoint {

    private final TodoRepository repository;

    @Autowired
    public TodoEndpoint(TodoRepository repository) {
        this.repository = repository;
    }

    @ApiOperation("Get a list of all available todos")
    @RequestMapping(method = GET)
    public List<Todo> findAll() {
        return repository.findAll();
    }

    @ApiOperation("Get a specific todo identified by it's id")
    @RequestMapping(path = "/todo/{id}", method = GET)
    public Todo findOne(@PathVariable long id) {
        return repository.getOne(id);
    }

    @ApiOperation("Create a new todo. Note that the id will be auto generated.")
    @RequestMapping(path = "/todo", method = POST)
    public Todo addTodo(@RequestBody Todo newTodo) {
        return repository.save(newTodo);
    }

    @ApiOperation("Modify an existing todo.")
    @RequestMapping(path = "/todo/{id}", method = PUT)
    public ResponseEntity<Todo> updateTodo(@PathVariable long id, @RequestBody Todo todo) {
        Todo result = repository.getOne(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        result.setDone(todo.isDone());
        result.setText(todo.getText());
        return ResponseEntity.ok(repository.save(result));
    }

    @ApiOperation("Delete the todo with the given id.")
    @RequestMapping(path = "/todo/{id}", method = DELETE)
    public void deleteTodo(@PathVariable long id) {
        repository.deleteById(id);
    }

    @ApiOperation("Delete all todos with the given done status")
    @RequestMapping(method = DELETE)
    public void deleteByDone(@PathParam("done") boolean done) {
        repository.deleteByDone(done);
    }
}
