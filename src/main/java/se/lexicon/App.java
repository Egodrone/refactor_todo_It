package se.lexicon;



import se.lexicon.dao.PeopleImpl;
import se.lexicon.dao.TodoItemsImpl;
import se.lexicon.dao.db.DbConnection;
import se.lexicon.model.Person;
import se.lexicon.model.Todo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;



public class App
{
    public static void main( String[] args )
    {
        System.out.println( "--- Todo application ---" );

        // test connection to the database
        /*
        String query = "SELECT * FROM person";
        try (
                PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query)
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        // Person implementation
        PeopleImpl peopleImpl = new PeopleImpl();

        // Create person
        //Person createdPerson = peopleImpl.create(new Person("Sonny", "Gollibani"));

        //Find all people
        Collection<Person> peopleCollection = peopleImpl.findAll();
        peopleCollection.forEach(System.out::println);

        //Find Person by id
        Person foundById = peopleImpl.findById(2);
        System.out.println(foundById.toString());

        //Find Person by name
        String findName = "Hanna";
        peopleCollection = peopleImpl.findByName(findName);
        peopleCollection.forEach(System.out::println);

        //Update Person
        Person updatedPerson = peopleImpl.update(new Person(3, "Jocko", "Willink"));
        System.out.println(updatedPerson.toString());

        //Delete Person
        boolean status = peopleImpl.deleteById(1);
        System.out.println(status);

        //To do implementation
        TodoItemsImpl todoImpl = new TodoItemsImpl();
        //Create To do
        //title, `description`, deadline, done, assignee_id
        LocalDate date = LocalDate.parse("2021-04-02");
        //3 (assignee_id) references to the Person
        Todo createTodo = todoImpl.create(new Todo("Gogo", "GG", date, 0, 3));

        //Find allTodo
        Collection<Todo> cTodo = todoImpl.findAll();
        cTodo.forEach(System.out::println);

        //findById
        Todo todoFindById = todoImpl.findById(3);
        System.out.println(todoFindById.toString());

        //Find by done status
        Collection<Todo> cTodoDoneStatus = todoImpl.findByDoneStatus(true);
        System.out.println("------------------------------------");
        cTodoDoneStatus.forEach(System.out::println);
    }



}
