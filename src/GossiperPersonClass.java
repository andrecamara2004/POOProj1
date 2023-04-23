import dataStructures.Array;
import dataStructures.ArrayClass;

public class GossiperPersonClass extends PersonClass {
	private String type;
	private Array<Gossip> gossips;
	
	public GossiperPersonClass(String name) {
		super(name);
		this.gossips = new ArrayClass<>();
		this.type = "gossiper";
	}
	
	public String getType() {
		return type;
	}

}
