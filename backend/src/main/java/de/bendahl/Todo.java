package de.bendahl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Benjamin Dahlmanns
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Todo {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String text;

    @Column
    private boolean done;

    Todo() {}

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;

    }

    public void setDone(boolean done) {
        this.done = done;
    }


}
