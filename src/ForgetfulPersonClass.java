public class ForgetfulPersonClass extends PersonClass implements ForgetFulPerson{

	private Gossip[] gossips;
	private String type;
    public ForgetfulPersonClass(Gossip[] gossips, String name) {
        super(name);
        this.gossips = gossips;
        this.type = "forgetful";
    }
    
    public String getType() {
    	return type;
    }

}
