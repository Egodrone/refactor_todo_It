package se.lexicon.dao;



import se.lexicon.dao.db.DbConnection;
import se.lexicon.model.Person;
import se.lexicon.model.Todo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;



public class TodoItemsImpl implements TodoItemsInterface {
    @Override
    public Todo create(Todo todo) {
        Todo t = new Todo();

        String query = "INSERT INTO todo_item(title, `description`, deadline, done, assignee_id) VALUES('"
                + todo.getTitle()
                + "', '" + todo.getDescription()
                + "', '" + todo.getDeadline()
                + "', " + todo.getDone()
                + ", " + todo.getAssignee_id() + ")";

        try(
                PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query)
        ) {
            int key = preparedStatement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            todo.setTodo_id(key);
            t = todo;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return t;
    }



    @Override
    public Collection<Todo> findAll() {
        Collection<Todo> cTodo = new ArrayList<>();

        String query = "SELECT * FROM todo_item";

        try(
                PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query)
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                cTodo.add(new Todo(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getInt(5),
                        resultSet.getInt(6)
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return cTodo;
    }



    @Override
    public Todo findById(int id) {
        String query = "SELECT * FROM todo_item WHERE todo_id = ?";

        Todo t = new Todo();

        try (
                PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                t.setTodo_id(resultSet.getInt(1));
                t.setTitle(resultSet.getString(2));
                t.setDescription(resultSet.getString(3));
                t.setDeadline(resultSet.getDate(4).toLocalDate());
                t.setDone(resultSet.getInt(5));
                t.setAssignee_id(resultSet.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;
    }



    @Override
    public Collection<Todo> findByDoneStatus(boolean status) {
        Collection<Todo> cTodo = new ArrayList<>();

        int taskDone = 0;
        if(status == true) {
            taskDone = 1;
        }
        String query = "SELECT * FROM todo_item WHERE done = ?";

        try(
                PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setInt(1, taskDone);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                cTodo.add(new Todo(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getInt(5),
                        resultSet.getInt(6)
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return cTodo;
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
