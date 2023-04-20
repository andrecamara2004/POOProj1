
public class GossiperPersonClass extends PersonClass {
	private String type;
	private Gossip[] gossips;
	
	public GossiperPersonClass(Gossip[] gossips, String name) {
		super(name);
		this.gossips = gossips;
		this.type = "gossiper";
	}
	
	public String getType() {
		return type;
	}

}
