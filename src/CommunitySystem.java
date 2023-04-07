import dataStructures.*;

public interface CommunitySystem {

    void addLandmark(int capacity, String name);

    boolean hasLandMark(String name);

    Iterator<LandMark> listAll();
    
    
}
