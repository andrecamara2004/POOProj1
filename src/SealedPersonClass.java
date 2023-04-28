import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public class SealedPersonClass extends PersonClass {
	private String type;
	private Array<Gossip> gossips;
	private int posGossip;

	public SealedPersonClass(String name) {
		super(name);
		this.gossips = new ArrayClass<>();
		this.type = "sealed";
		this.posGossip = 0;
	}

	public String getType() {
		return type;
	}

	@Override
	public boolean hasGossipsToShare() {
		boolean check = false;
		for (int i = 0; i < gossips.size(); i++) {
			Gossip gossip = gossips.get(i);
			if (gossip.isTargeting(this)) {
				check = true;
				break;
			}
		}

		return check;
	}

	@Override
	public Iterator<Gossip> getGossipsToShare() {
		Gossip nextGossip = null;
		do {
			if (gossips.get(posGossip).isTargeting(this)) {
				nextGossip = gossips.get(posGossip);
			}
			
			posGossip++;
			if (posGossip == gossips.size()) {
				posGossip = 0;
			}
		} while (nextGossip == null);

		Array<Gossip> gossipsToShare = new ArrayClass<>(1);
		gossipsToShare.insertLast(nextGossip);
		return gossipsToShare.iterator();
	}

	@Override
	public void listenGossip(Gossip next) {
		gossips.insertLast(next);
	}

	public int getCapacity() {
        return 0;
    }

}