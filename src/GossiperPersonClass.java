import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public class GossiperPersonClass extends PersonClass {

	public GossiperPersonClass(String name) {
		super(name);
		super.gossips = new ArrayClass<>();
	}

	@Override
	public Iterator<Gossip> getGossipsToShare() {
		if (gossips.size() <= 3) {
			return gossips.iterator();
		}

		Array<Gossip> gossipsToShare = new ArrayClass<>(3);
		for (int i = 0; i < 3; i++) {
			gossipsToShare.insertAt(gossips.get(posGossip), i);
			posGossip++;
			if (posGossip == gossips.size()) {
				posGossip = 0;
			}
		}

		return gossipsToShare.iterator();
	}

	

	@Override
	public void listenGossip(Gossip next) {
		gossips.insertLast(next);
	}

	public int getCapacity() {
        return 0;
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
}