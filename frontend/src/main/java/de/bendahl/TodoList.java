package de.bendahl;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;


/**
 * This class controls the behavior of the actual todo list
 *
 * Original source taken from: https://github.com/vaadin-marcus/spring-boot-todo/
 */
@UIScope
@SpringComponent
class TodoList extends VerticalLayout implements TodoChangeListener {

    private final TodoService todoService;

    @Autowired
    public TodoList(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostConstruct
    void init() {
        setWidth("80%");

        update();
    }

    private void update() {
        setTodos(todoService.getAllTodos());
    }

    private void setTodos(List<Todo> todos) {
        removeAllComponents();
        todos.forEach(todo -> addComponent(new TodoLayout(todo, this)));
    }

    void addTodo(Todo todo) {
        todoService.save(todo);
        update();
    }

    @Override
    public void todoChanged(Todo todo) {
        todoService.change(todo);
        update();
    }


    public void deleteCompleted() {
        todoService.deleteByDone(true);
        update();
    }}
