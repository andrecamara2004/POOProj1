import dataStructures.*;

public interface CommunitySystem {

	/**
	 * Sends the person with the respective <code>name</code> home
	 * @param name
	 */
    void personGoesHome(String name);
	
    /**
     * Adds the landmark to the community with the respective <code>capacity</code> and <code>name</code>
     * @param capacity
     * @param name
     */
    void addLandmark(int capacity, String name);

    /**
     * Checks if the community has a landmark with the respective <code>name</code> in it
     * @param name
     * @return returns <code>true</code> if the landmark's <code>name</code> exists in the community 
     */
    boolean hasLandMark(String name);
    
    /**
     * Adds a ForgetfulPerson to the community with the respective <code>name</code> and <code>capacity</code>
     * @param name
     * @param capacity
     */
    void addForgetfulPerson(String name, int capacity);
    
    /**
     * Adds a GossiperPerson to the community with the respective <code>name</code>
     * @param name
     */
    void addGossiperPerson(String name);
    
    /**
     * Adds a SealedPerson to the community with the respective <code>name</code>
     * @param name
     */
    void addSealedPerson(String name);

    /**
     * Checks if the community has a person with the respective <code>name</code> in it
     * @param name
     * @return returns <code>true</code> if the person's <code>name</code> exists in the community
     */
    boolean hasPerson(String name);

    /**
     * Checks if the <code>landmark</code> has a person with the respective <code>name</code> in it
     * @param name
     * @param landmark
     * @return returns <code>true</code> if the person's <code>name</code> exists in the <code>landmark</code>
     */
    boolean landMarkHasPerson(String name, String landmark);

    /**
     * Checks if the <code>landmark</code> capacity is full
     * @param landmark
     * @return returns <code>true</code> if the landmark's capacity is full
     */
    boolean isLandmarkFull(String landmark);
    
    /**
     * Lists all the landmarks in the community
     * @return all the landmarks
     */
    Iterator<LandMark> listAll();

    /**
     * Lists all the people in the community
     * @return all the people
     */
    Iterator<Person> listAllPeople();

    /**
     * Changes the current spot of the person with this <code>name</code> to the <code>landmark</code>
     * @param name
     * @param landmark
     */
    void movePersonToLandmark(String name, String landmark);

    /**
     * Checks if the person with the respective <code>name</code> is at home
     * @param name
     * @return <code>true</code> if the person's with the respective<code>name</code> is at home
     */
    boolean isPersonAtHome(String name);

    /**
     * Removes the person with this <code>name</code> of the current <code>landmark</code>
     * @param name
     * @param landmark
     */
    void removePersonOfLandmark(String name, String landmark);

    /**
     * Checks if two people with the respective <code>name1</code> and <code>name2</code> are in the same landmark
     * @param name1
     * @param name2
     * @return returns <code>true</code> if both persons with the <code>name1</code> and <code>name2</code> are in the same landmark
     */
    boolean isAtSameLandMark(String name1, String name2);

    /**
     * Returns the landmark of the person with this <code>name</code>
     * @param name
     * @return the landmark
     */
    LandMark getLandmarkOfPerson(String name);

    /**
     * Adds the person with the <code>name1</code> to the group of the person with <code>name2</code>
     * @param name1
     * @param name2
     */
    void personJoinsGroup(String name1, String name2);

    /**
     * Checks if two people with the respective <code>name1</code> and <code>name2</code> are in the same group
     * @param name1
     * @param name2
     * @return returns <code>true</code> if both persons with the <code>name1</code> and <code>name2</code> are in the same group
     */
    boolean isAtSameGroup(String name1, String name2);

    /**
     * Lists all the people in the group of the person with this <code>name</code>
     * @param name
     * @return all the people in the group of the person
     */
    Iterator<Person> listAllPeopleInGroup(String name);

    /**
     * Returns the number of groups of the <code>landmark</code>
     * @param landmark
     * @return the number of groups
     */
    int getAmountOfGroupsByLandmark(String landmark);

    /**
     * Lists all the groups in the <code>landmark</code>
     * @param landmark
     * @return all the groups
     */
    Iterator<Group> listAllGroups(String landmark);

    /**
     * Checks if the <code>landmark</code> is empty
     * @param landmark
     * @return returns <code>true</code> if the <code>landmark</code> is empty
     */
    boolean isLandmarkEmpty(String landmark);

    /**
     * Checks if the person with this <code>name</code> isn't with anybody in a group
     * @param name
     * @return returns <code>true</code> if the person's <code>name</code> isn't in a group with more than one person
     */
    boolean isPersonAlone(String name);

    /**
     * Removes the person with this <code>name</code> from the current group and puts it in a group alone
     * @param name
     */
    void isolatePerson(String name);

    /**
     *	The <code>person</code> starts a <code>gossip</code> and saves it in an array of gossips
     *	@param gossip
     *	@param person
     */
	void startGossip(Gossip gossip, Person person);

	/**
     * Lists all the gossips of the person with the respective <code>name</code>
     * @param name
     * @return all the gossips
     */
	Iterator<Gossip> gossip(String name);
	
	 /**
     * Checks if the person with this <code>name</code> doesn't know any gossip
     * @param name
     * @return returns <code>true</code> if the person's <code>name</code> doesn't know any gossip
     */
	boolean personKnowsNothing(String name);
	
	Person getPerson(String name);

	 /**
     * Checks if the person with this <code>name</code> is able to share a gossip
     * @param name
     * @return returns <code>true</code> if the person is able to share a gossip
     */
	boolean isPersonAbleToShareAGossip(String name);

	 /**
     *
     */
	boolean hasGossip(String owner, Array<Person> targets, String gossipString);

	/*
	 * 
	 */
	Array<Gossip> getGossipsAboutPerson(String name);

     int getNumOfListeners (Gossip gossip);

     boolean hasGossips();

    boolean hasSharedGossips();

    Iterator<Gossip> listMostSharedGossips();

}
