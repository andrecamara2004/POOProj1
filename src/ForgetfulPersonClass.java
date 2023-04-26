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
    }
    
    public String getType() {
    	return type;
    }

    @Override
    public Iterator<Gossip> getGossipsToShare() {
        Array<Gossip> gossipsToShare = new ArrayClass<>(1);
        gossipsToShare.insertLast(gossips.get(posGossip));
        posGossip++;
        if(posGossip >= capacity) {
            posGossip = 0;
        }

        return gossipsToShare.iterator();
    }

    @Override
    public void listenGossip(Gossip next) {
        if(gossips.size() == capacity) {
            gossips.removeAt(0);
        }
        gossips.insertLast(next);
    }

    @Override
    public void setGroup(Group otherGroup) {
        super.setGroup(otherGroup);
        posGossip = 0;
    }

}
