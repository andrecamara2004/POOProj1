import dataStructures.*;

public interface Person {

    String getName();
    String getType();
    //hasGossips
    int getNumOfGossips();
    void goToHome();
    LandMark getCurrLandmark();
    boolean isAtHome();
    void goToNewLandMark(LandMark landmark);
    Group getCurrGroup();
    void setGroup(Group group);
    void clearGroup();
    boolean isAlone();
    Array<Gossip> getGossips();
    boolean hasGossipsToShare();
    Iterator<Gossip> getGossipsToShare();
    void listenGossip(Gossip next);
    int getCapacity();
}
