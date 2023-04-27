import dataStructures.*;

public interface LandMark {
    int getCapacity();

    String getName();

    int getOccupation();

    Person getPersonInside(String name);

    void addPerson(Person person);

    void removePerson(Person person);

    void joinGroup(Person person1, Person person2);

    int getAmountOfGroups();

    Iterator<Group> listAllGroups();

    Array<Group> getGroups();

    void isolate(Person person);
}
