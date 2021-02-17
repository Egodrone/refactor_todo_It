package se.lexicon.dao;



import se.lexicon.dao.db.DbConnection;
import se.lexicon.model.Person;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;



public class PeopleImpl implements PeopleInterface {
    @Override
    public Person create(Person person) {
        Person p = new Person();

        String query = "INSERT INTO person(first_name, last_name) VALUES('"
                + person.getFirst_name()
                + "', '" + person.getLast_name() + "')";

        try(
                PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query)
        ) {
            int key = preparedStatement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            person.setPerson_id(key);
            p = person;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return p;
    }



    @Override
    public Collection<Person> findAll() {
        return null;
    }



    @Override
    public Person findById(int id) {
        return null;
    }



    @Override
    public Collection<Person> findByName(String name) {
        return null;
    }



    @Override
    public Person update(Person person) {
        return null;
    }



    @Override
    public boolean deleteById(int id) {
        return false;
    }



}
