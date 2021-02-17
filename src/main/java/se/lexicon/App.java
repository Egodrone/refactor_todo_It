package se.lexicon;



import se.lexicon.dao.PeopleImpl;
import se.lexicon.dao.db.DbConnection;
import se.lexicon.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        //Person createdPerson = peopleImpl.create(new Person("Hanna", "Nilsson"));

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
    }



}
