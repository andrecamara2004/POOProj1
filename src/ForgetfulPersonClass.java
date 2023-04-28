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
        if (posGossip >= gossips.size()) {
            posGossip = 0;
        }

        return gossipsToShare.iterator();
    }

    @Override
    public void listenGossip(Gossip next) {
        if (gossips.size() == capacity) {
            gossips.removeAt(0);
            // Adjust posGossip
            if (posGossip > 0) {
                posGossip--;
            }
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
            if (gossips.get(i).getShares() > 0) {
                check = true;
                break;
            }
        }

        return check;
    }

	@Override
	public Iterator<Gossip> getGossipsList() {
		Array<Gossip> list = new ArrayClass<Gossip>(gossips.size());
		for (int i = 0; i < gossips.size(); i++) {
			list.insertAt(gossips.get((posGossip + i) % gossips.size()), i);
		}

		return list.iterator();
	}    

}
