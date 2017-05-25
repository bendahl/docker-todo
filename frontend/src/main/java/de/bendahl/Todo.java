package de.bendahl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 *
 * @author Benjamin Dahlmanns
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Todo {

    private long id;
    private String text;
    private boolean done;

    @JsonCreator
    public Todo(@JsonProperty("id") long id,
                @JsonProperty("text") String text,
                @JsonProperty("done") boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }

    public Todo(String text, boolean done) {
        this(0, text, done);
    }

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
