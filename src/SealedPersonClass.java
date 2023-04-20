
public class SealedPersonClass extends PersonClass {
	private String type;
	private Gossip[] gossips;
	
	public SealedPersonClass(Gossip[] gossips, String name) {
		super(name);
		this.gossips = gossips;
		this.type = "sealed";
	}
	
	public String getType() {
		return type;
	}

}
