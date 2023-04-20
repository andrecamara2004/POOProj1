import dataStructures.*;

public class CommunitySystemClass implements CommunitySystem{

    private Array<Person> people;
    private Array<LandMark> landmarks;
    private Array<Gossip> gossips;

    public CommunitySystemClass() {
        this.landmarks = new ArrayClass<>();
        this.people = new ArrayClass<>();
        this.gossips = new ArrayClass<>();
    }

    public void addForgetfulPerson(Gossip[] gossips, String name) {
    	Person forgetfulPerson= new ForgetfulPersonClass(gossips, name);
    	people.insertLast(forgetfulPerson);
    }
    
    public void addGossiperPerson(Gossip[] gossips, String name) {
    	Person gossiperPerson = new GossiperPersonClass(gossips, name);
    	people.insertLast(gossiperPerson);
    }
    
    public void addSealedPerson(Gossip[] gossips, String name) {
    	Person sealedPerson = new SealedPersonClass(gossips, name);
    	people.insertLast(sealedPerson);
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
