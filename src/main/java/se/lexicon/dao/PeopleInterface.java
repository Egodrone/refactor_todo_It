package se.lexicon.dao;


import java.util.Collection;



public interface PeopleInterface {
    Person create(Person person);
    Collection<Person> findAll();
    Person findById(int id);
    Collection<Person> findByName(String name);
    Person update(Person person);
    boolean deleteById(int id);
}
