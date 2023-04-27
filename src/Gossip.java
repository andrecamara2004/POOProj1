import dataStructures.*;
public interface Gossip {

    Person getOwner();

    String getGossip();


    Iterator<Person> getTargetsIter();

    Iterator<Person> getListenersIter();

    boolean isTargeting(Person person);

    boolean equals(Object obj);

    Array<Person> getTargets();

    Array<Person> getListeners();

}
