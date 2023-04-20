import dataStructures.*;

public interface CommunitySystem {
	
    void addLandmark(int capacity, String name);

    boolean hasLandMark(String name);
    
    void addForgetfulPerson(Gossip[] gossips, String name);
    
    void addGossiperPerson(Gossip[] gossips, String name);
    
    void addSealedPerson(Gossip[] gossips, String name);
    
    Iterator<LandMark> listAll();
}
