import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public class ForgetfulPersonClass extends PersonClass {

    private Array<Gossip> gossips;
    private String type;
    private int capacity;
    private int posGossip;

    public ForgetfulPersonClass(String name, int capacity) {
        super(name);
        this.gossips = new ArrayClass<>(capacity);
        this.type = "forgetful";
        this.posGossip = 0;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    @Override
    public Iterator<Gossip> getGossipsToShare() {
        Array<Gossip> gossipsToShare = new ArrayClass<>(1);
        gossipsToShare.insertLast(gossips.get(posGossip));
        posGossip++;
        if (posGossip >= capacity) {
            posGossip = 0;
        }

        return gossipsToShare.iterator();
    }

    @Override
    public void listenGossip(Gossip next) {
        if (gossips.size() == capacity) {
            gossips.removeAt(0);
        }
        gossips.insertLast(next);
    }

    @Override
    public void setGroup(Group otherGroup) {
        super.setGroup(otherGroup);
        posGossip = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public Array<Gossip> getGossips() {
        return gossips;
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
    public boolean hasSharedAGossip(Person person) {
        boolean check = false;
        for (int i = 0; i < gossips.size(); i++) {
            for (int j = 0; j < person.getGossips().size(); j++) {
                if (this.gossips.get(i).equals(person.getGossips().get(j))) {
                    check = true;
                }
            }
        }

        return check;
    }

}
