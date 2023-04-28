import dataStructures.*;

public interface Gossip {

    /*
     * Returns the owner of the gossip
     * 
     * @return owner
     */
    Person getOwner();

    /*
     * Returns the gossip
     * 
     * @return gossip
     */
    String getGossip();

    /**
     * Lists all the targets of the gossip
     * 
     * @return lists all the targets
     */
    Iterator<Person> getTargetsIter();

    /**
     * Checks if the gossip is targeting a certain <code>person</code>
     * 
     * @param person
     * @return returns <code>true</code> if the gossip is targeting the
     *         <code>person</code>
     */
    boolean isTargeting(Person person);

    /**
     * 
     */
    boolean equals(Object obj);

    /**
     * Gets the name of the targets
     * 
     * @return targets
     */
    Array<Person> getTargets();

    void registerShare();

    int getShares();

    void setSharesToZero();
}