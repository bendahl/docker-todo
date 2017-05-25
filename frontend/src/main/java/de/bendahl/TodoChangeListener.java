package de.bendahl;

/**
 * Original source taken from: https://github.com/vaadin-marcus/spring-boot-todo/
 */
public interface TodoChangeListener {
    void todoChanged(Todo todo);
}
