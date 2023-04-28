import dataStructures.*;

public abstract class PersonClass implements Person {

    private String name;
    private LandMark landmark;
    private Group group;

    public PersonClass(String name) {
        this.name = name;
        this.landmark = null;
        this.group = null;
    }

    @Override
    public String getName() {
        return name;
    }

    public abstract String getType();

    @Override
    public abstract int getNumOfGossips();

    @Override
    public void goToHome() {
        landmark = null;
    }

    @Override
    public LandMark getCurrLandmark() {
        return landmark;
    }

    @Override
    public boolean isAtHome() {
        return landmark == null;
    }

    @Override
    public void goToNewLandMark(LandMark newLandmark) {
        landmark = newLandmark;
    }

    @Override
    public Group getCurrGroup() {
        return group;
    }

    @Override
    public void setGroup(Group otherGroup) {
        group = otherGroup;

    }

    @Override
    public void clearGroup() {
        group = null;
    }

    @Override
    public boolean isAlone() {
        return group == null || group.count() == 1;
    }

    // PRE: hasGossips()
    @Override
    public boolean hasGossipsToShare() {
        return true;
    }

    @Override
    public abstract Iterator<Gossip> getGossipsToShare();
    @Override
    public abstract Iterator<Gossip> getGossipsList();

    @Override
    public abstract void listenGossip(Gossip next);

    public abstract int getCapacity();

    @Override
    public abstract boolean hasGossip(Gossip sharedGossip);

}