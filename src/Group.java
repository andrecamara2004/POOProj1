import dataStructures.*;

public interface Group {

    void join (Person person);

    void isolate (Person person);

    boolean isPersonAtGroup (Person person);

    Iterator<Person> listAllPeople ();

    int count();
}