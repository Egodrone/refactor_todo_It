package se.lexicon.dao;



import se.lexicon.model.Person;
import se.lexicon.model.Todo;
import java.util.Collection;



public class TodoItemsImpl implements TodoItemsInterface {
    @Override
    public Todo create(Todo todo) {
        return null;
    }

    @Override
    public Collection<Todo> findAll() {
        return null;
    }

    @Override
    public Todo findById(int id) {
        return null;
    }

    @Override
    public Collection<Todo> findByDoneStatus(boolean status) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(int id) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(Person person) {
        return null;
    }

    @Override
    public Collection<Todo> findByUnassignedTodoItems() {
        return null;
    }

    @Override
    public Todo update(Todo todo) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

}
