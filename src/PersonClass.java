import dataStructures.*;

public abstract class PersonClass implements Person {

    private String name;
    private LandMark landmark;
    private Group group;
    protected Array<Gossip> gossips;
    protected int posGossip;

    public PersonClass(String name) {
        this.name = name;
        this.landmark = null;
        this.group = null;
        this.posGossip = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumOfGossips() {
        return gossips.size();
    }

    @Override
    public boolean hasGossip(Gossip sharedGossip) {
        return gossips.searchForward(sharedGossip);
    }

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
    public Iterator<Gossip> getGossipsList() {
        Array<Gossip> list = new ArrayClass<Gossip>(gossips.size());
        for (int i = 0; i < gossips.size(); i++) {
            list.insertAt(gossips.get((posGossip + i) % gossips.size()), i);
        }

        return list.iterator();
    }

    @Override
    public abstract void listenGossip(Gossip next);

    @Override
    public boolean hasSharedAGossip(Person person) {
        boolean check = false;
        for (int i = 0; i < gossips.size(); i++) {
            if (gossips.get(i).getShares() > 0) {
                check = true;
                break;
            }
        }

        return check;
    }

    @Override
    public Array<Gossip> getGossips() {
        return gossips;
    }
}