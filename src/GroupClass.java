import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public class GroupClass implements Group {

    private Array<Person> group;

    public GroupClass(Person person) {
        group = new ArrayClass<>();
        group.insertLast(person);
        person.setGroup(this);
    }

    @Override
    public boolean isPersonAtGroup(Person person) {
        return group.searchForward(person);
    }

    @Override
    public void isolate(Person person) {
        int pos = group.searchIndexOf(person);
        group.removeAt(pos);
        person.clearGroup();
        
    }

    @Override
    public void join(Person person) {
        group.insertLast(person);
        person.setGroup(this);

    }

    @Override
    public Iterator<Person> listAllPeople() {
        return group.iterator();

    }

    @Override
    public int count() {
        return group.size();
    }

}
