package se.lexicon;



import se.lexicon.dao.PeopleImpl;
import se.lexicon.dao.TodoItemsImpl;
import se.lexicon.model.Person;
import se.lexicon.model.Todo;
import java.time.LocalDate;
import java.util.Collection;



public class App
{
    public static void main( String[] args )
    {
        System.out.println( "--- Todo application ---" );

        // Person implementation
        PeopleImpl peopleImpl = new PeopleImpl();

        System.out.println("------------------------------------");
        // Create person
        Person createdPerson = peopleImpl.create(new Person("VeryImportantDude", "Lastname"));

        System.out.println("------------------------------------");
        //Find all people
        Collection<Person> peopleCollection = peopleImpl.findAll();
        peopleCollection.forEach(System.out::println);

        System.out.println("------------------------------------");
        //Find Person by id
        Person foundById = peopleImpl.findById(2);
        System.out.println(foundById.toString());

        System.out.println("------------------------------------");
        //Find Person by name
        String findName = "Hanna";
        peopleCollection = peopleImpl.findByName(findName);
        peopleCollection.forEach(System.out::println);

        System.out.println("------------------------------------");
        //Update Person
        Person updatedPerson = peopleImpl.update(new Person(3, "Jocko", "Willink"));
        System.out.println(updatedPerson.toString());

        System.out.println("------------------------------------");
        //Delete Person
        boolean status = peopleImpl.deleteById(1);
        System.out.println(status);

        System.out.println("------------------------------------");
        //To do implementation
        TodoItemsImpl todoImpl = new TodoItemsImpl();
        //Create To do
        //title, `description`, deadline, done, assignee_id
        LocalDate date = LocalDate.parse("2021-04-02");
        //3 (assignee_id) references to the Person
        Todo createTodo = todoImpl.create(new Todo("Bitcoin", "DoNotBuyNow", date, 0, 3));

        System.out.println("------------------------------------");
        //Find allTodo
        Collection<Todo> cTodo = todoImpl.findAll();
        cTodo.forEach(System.out::println);

        System.out.println("------------------------------------");
        //findById
        Todo todoFindById = todoImpl.findById(3);
        System.out.println(todoFindById.toString());

        System.out.println("------------------------------------");
        //Find by done status
        Collection<Todo> cTodoDoneStatus = todoImpl.findByDoneStatus(true);
        cTodoDoneStatus.forEach(System.out::println);

        System.out.println("------------------------------------");
        //findByAssignee id
        Collection<Todo> cTodoFindByAssignee = todoImpl.findByAssignee(3);
        cTodoFindByAssignee.forEach(System.out::println);

        System.out.println("------------------------------------");
        //findByAssignee Person
        // Check later
        Collection<Todo> cPersonFindByAssignee = todoImpl.findByAssignee(updatedPerson);
        cPersonFindByAssignee.forEach(System.out::println);

        System.out.println("------------------------------------");
        //deleteById
        boolean todoTaskDelStatus = todoImpl.deleteById(createTodo.getTodo_id());
        //Test for the invalid boolean if you want
        //boolean todoTaskDelStatus = todoImpl.deleteById(10000);
        //boolean todoTaskDelStatus = todoImpl.deleteById(10);
        System.out.println(todoTaskDelStatus);


    }



}
