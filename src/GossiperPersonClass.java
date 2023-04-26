import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public class GossiperPersonClass extends PersonClass {
	private String type;
	private Array<Gossip> gossips;
	private int posGossip;

	public GossiperPersonClass(String name) {
		super(name);
		this.gossips = new ArrayClass<>();
		this.type = "gossiper";
		this.posGossip = 0;
	}

	public String getType() {
		return type;
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

}
