import dataStructures.*;

public class CommunitySystemClass implements CommunitySystem{

    
    private Array<LandMark> landmarks;

    public CommunitySystemClass() {
        this.landmarks = new ArrayClass<>();
    }

    @Override
    public void addLandmark(int capacity, String name) {
        LandMark landmark = new LandMarkClass(capacity, name);
        landmarks.insertLast(landmark);
        
    }

    @Override
    public boolean hasLandMark(String name) {
        return getLandMark(name) != null;
    }

    private LandMark getLandMark(String name) {
        LandMark landmark = null;
        Iterator<LandMark> iter = this.landmarks.iterator();
        while(iter.hasNext()) {
            LandMark otherLandMark = iter.next();
            if(otherLandMark.getName().equals(name)) {
                landmark = otherLandMark;
                break;
            }
        }

        return landmark;
    }

    @Override
    public Iterator<LandMark> listAll() {
        return this.landmarks.iterator();
    }

    
    
}
