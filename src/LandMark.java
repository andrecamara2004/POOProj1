import dataStructures.*;

public interface LandMark {
	
	/**
	 * Returns the capacity of the landmark
	 * @return capacity
	 */
    int getCapacity();

    /**
     * Returns the name of the landmark
     * @return name
     */
    String getName();
    
    /**
     * Returns the occupation of the landmark
     * @return occupation
     */
    int getOccupation();

    /**
     * Returns the name of the person inside the landmark
     * @param name
     * @return person
     */
    Person getPersonInside(String name);

    /**
     * Adds a <code>person</code> to the landmark
     * @param person
     */
    void addPerson(Person person);
    
    /**
     * Removes a <code>person</code> of the landmark
     * @param person
     */
    void removePerson(Person person);

    /**
     * Adds <code>person1</code> to <code>person2</code> group
     * @param person1
     * @param person2
     */
    void joinGroup(Person person1, Person person2);

    /**
     * Returns the number of groups in the landmark
     * @return number of groups
     */
    int getAmountOfGroups();

    /**
     * Lists all the groups in the landmark
     * @return lists all groups
     */
    Iterator<Group> listAllGroups();
    
    Array<Group> getGroups();
    
    void isolate(Person person);
}
