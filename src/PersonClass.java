import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public abstract class PersonClass implements Person{

    private String name;
    private LandMark landmark;
    private Array<Gossip> gossips;
    private Group group;

    public PersonClass(String name) {
        this.name = name;
        this.landmark = null;
        this.gossips = new ArrayClass<>();
        this.group = null;
    }


    @Override
    public String getName() {
        return name;
    }
    
    
    public abstract String getType();

    @Override
    public int getNumOfGossips() {
        return gossips.size();
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


    @Override
    public Array<Gossip> getGossips() {
        return gossips;
    }


    //PRE: hasGossips()
    @Override
    public boolean hasGossipsToShare() {
        return true;
    }


    @Override
    public abstract Iterator<Gossip> getGossipsToShare();


    @Override
    public abstract void listenGossip(Gossip next);

    public abstract int getCapacity();
}
