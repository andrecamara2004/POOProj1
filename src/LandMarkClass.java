
import dataStructures.Iterator;
import dataStructures.Array;
import dataStructures.ArrayClass;

public class LandMarkClass implements LandMark {

    private int capacity;
    private String name;
    private Array<Person> people;
    private Array<Group> groups;

    public LandMarkClass(int capacity, String name) {
        this.capacity = capacity;
        this.name = name;
        this.people = new ArrayClass<>(capacity);
        this.groups = new ArrayClass<>();
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getOccupation() {
        return people.size();
    }

    @Override
    public Person getPersonInside(String name) {
        Person person = null;
        Iterator<Person> iter = this.people.iterator();
        while (iter.hasNext()) {
            Person otherPerson = iter.next();
            if (otherPerson.getName().equals(name)) {
                person = otherPerson;
                break;
            }
        }

        return person;
    }

    @Override
    public void addPerson(Person person) {
        people.insertLast(person);
        person.goToNewLandMark(this);
        Group group = new GroupClass(person);
        groups.insertLast(group);
    }

    @Override
    public void removePerson(Person person) {

        // is alone in a group?
        Group group = person.getCurrGroup();
        if (person.isAlone()) {
            // yes: need to remove group
            groups.removeAt(groups.searchIndexOf(group));
        }

        // mark person as without group;
        person.clearGroup();

        // remove person from landmark
        people.removeAt(people.searchIndexOf(person));
    }

    @Override
    public void joinGroup(Person person1, Person person2) {
        Group group1 = person1.getCurrGroup();
        if (person1.isAlone()) {
            groups.removeAt(groups.searchIndexOf(group1));
        }

        group1.isolate(person1);

        Group group2 = person2.getCurrGroup();
        group2.join(person1);
    }

    @Override
    public int getAmountOfGroups() {
        return groups.size();
    }

    @Override
    public Iterator<Group> listAllGroups() {
        return groups.iterator();
    }

}
