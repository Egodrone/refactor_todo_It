package se.lexicon.model;



import java.time.LocalDate;
import java.util.Objects;


public class TodoItems {
    private int todo_id;
    private String title;
    private String description;
    private LocalDate deadline;
    private int done;
    private int assignee_id;

    public TodoItems() {
    }

    public TodoItems(int todo_id, String title, String description, LocalDate deadline, int done, int assignee_id) {
        this.todo_id = todo_id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.assignee_id = assignee_id;
    }

    public int getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(int todo_id) {
        this.todo_id = todo_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public int getAssignee_id() {
        return assignee_id;
    }

    public void setAssignee_id(int assignee_id) {
        this.assignee_id = assignee_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItems todoItems = (TodoItems) o;
        return todo_id == todoItems.todo_id && done == todoItems.done && assignee_id == todoItems.assignee_id && Objects.equals(title, todoItems.title) && Objects.equals(description, todoItems.description) && Objects.equals(deadline, todoItems.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todo_id, title, description, deadline, done, assignee_id);
    }

    @Override
    public String toString() {
        return "TodoItems{" +
                "todo_id=" + todo_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                ", assignee_id=" + assignee_id +
                '}';
    }

}
