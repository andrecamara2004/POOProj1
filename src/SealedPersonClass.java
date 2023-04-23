import dataStructures.Array;
import dataStructures.ArrayClass;

public class SealedPersonClass extends PersonClass {
	private String type;
	private Array<Gossip> gossips;


	public SealedPersonClass(String name) {
		super(name);
		this.gossips = new ArrayClass<>();
		this.type = "sealed";
	}

	public String getType() {
		return type;
	}

}
