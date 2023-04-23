import dataStructures.Array;
import dataStructures.ArrayClass;

public class ForgetfulPersonClass extends PersonClass {

	private Array<Gossip> gossips;
	private String type;
    private int capacity;
    public ForgetfulPersonClass(String name, int capacity) {
        super(name);
        this.gossips = new ArrayClass<>(capacity);
        this.type = "forgetful";
    }
    
    public String getType() {
    	return type;
    }

    

}
