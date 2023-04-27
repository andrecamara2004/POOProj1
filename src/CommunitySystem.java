import dataStructures.*;

public interface CommunitySystem {

    void personGoesHome(String name);
	
    void addLandmark(int capacity, String name);

    boolean hasLandMark(String name);
    
    void addForgetfulPerson(String name, int capacity);
    
    void addGossiperPerson(String name);
    
    void addSealedPerson(String name);

    boolean hasPerson(String name);

    boolean landMarkHasPerson(String name, String landmark);

    boolean isLandmarkFull(String landmark);
    
    Iterator<LandMark> listAll();

    Iterator<Person> listAllPeople();

    void movePersonToLandmark(String name, String landmark);

    boolean isPersonAtHome(String name);

    void removePersonOfLandmark(String name, String landmark);

    boolean isAtSameLandMark(String name1, String name2);

    LandMark getLandmarkOfPerson(String name);

    void personJoinsGroup(String name1, String name2);

    boolean isAtSameGroup(String name1, String name2);

    Iterator<Person> listAllPeopleInGroup(String name);

    int getAmountOfGroupsByLandmark(String landmark);

    Iterator<Group> listAllGroups(String landmark);

    boolean isLandmarkEmpty(String landmark);

    boolean isPersonAlone(String name);

    void isolatePerson(String name);

	void startGossip(Gossip gossip, Person person);

	Iterator<Gossip> gossip(String name);

    boolean personKnowsNothing(String name);

    Person getPerson(String name);

    boolean isPersonAbleToShareAGossip(String name);

    boolean hasGossip(String owner, Array<Person> targets, String gossipString);
}
