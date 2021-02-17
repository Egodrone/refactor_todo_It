package se.lexicon.dao;



import se.lexicon.dao.db.DbConnection;
import se.lexicon.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


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
        Collection<Person> pCollection = new ArrayList<>();

        String query = "SELECT * FROM person";

        try(
                PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query)
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                pCollection.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return pCollection;
    }



    @Override
    public Person findById(int id) {
        String query = "SELECT * FROM person WHERE person_id = ?";

        Person p = new Person();

        try (
                PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                p.setPerson_id(resultSet.getInt(1));
                p.setFirst_name(resultSet.getString(2));
                p.setLast_name(resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }



    @Override
    public Collection<Person> findByName(String name) {
        Collection<Person> pCollection = new ArrayList<>();
        String query = "SELECT * FROM person WHERE first_name = ?";

        try (
                PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                pCollection.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pCollection;
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
