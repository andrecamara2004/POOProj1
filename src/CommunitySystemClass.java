import dataStructures.*;

public class CommunitySystemClass implements CommunitySystem {
	
	private Array<Gossip> gossips;
    private Array<Person> people;
    private Array<LandMark> landmarks;

    public CommunitySystemClass() {
        this.landmarks = new ArrayClass<>();
        this.people = new ArrayClass<>();
        this.gossips = new ArrayClass<>();
    }

    @Override
    public boolean isLandmarkFull(String landmark) {
        LandMark place = getLandMark(landmark);
        return place.getOccupation() == place.getCapacity();
    }

    public void addForgetfulPerson(String name, int capacity) {
        Person forgetfulPerson = new ForgetfulPersonClass(name, capacity);
        people.insertLast(forgetfulPerson);
    }

    public void addGossiperPerson(String name) {
        Person gossiperPerson = new GossiperPersonClass(name);
        people.insertLast(gossiperPerson);
    }

    public void addSealedPerson(String name) {
        Person sealedPerson = new SealedPersonClass(name);
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
        while (iter.hasNext()) {
            LandMark otherLandMark = iter.next();
            if (otherLandMark.getName().equals(name)) {
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

    @Override
    public Iterator<Person> listAllPeople() {
        return this.people.iterator();
    }

    @Override
    public boolean hasPerson(String name) {
        return getPerson(name) != null;

    }

    public boolean landMarkHasPerson(String name, String landmark) {
        LandMark place = getLandMark(landmark);
        return place.getPersonInside(name) != null;
    }

    @Override
    public void personGoesHome(String name) {
        Person person = getPerson(name);
        LandMark landMark = person.getCurrLandmark();
        landMark.removePerson(person);
        person.goToHome();
    }

    @Override
    public void movePersonToLandmark(String name, String landmark) {
        Person person = getPerson(name);
        // Person is in a landmark?
        if (!person.isAtHome()) {
            LandMark curLandmark = person.getCurrLandmark();
            curLandmark.removePerson(person);
            person.clearGroup();
        }

        LandMark place = getLandMark(landmark);
        place.addPerson(person);

    }

    @Override
    public boolean isPersonAtHome(String name) {
        Person person = getPerson(name);
        return person.isAtHome();
    }

    @Override
    public void removePersonOfLandmark(String name, String landmark) {
        Person person = getPerson(name);
        LandMark place = getLandMark(landmark);
        place.removePerson(person);
    }

    @Override
    public boolean isAtSameLandMark(String name1, String name2) {
        Person person1 = getPerson(name1);
        Person person2 = getPerson(name2);
        return person1.getCurrLandmark() == person2.getCurrLandmark();
    }

    @Override
    public LandMark getLandmarkOfPerson(String name) {
        Person person = getPerson(name);
        return person.getCurrLandmark();
    }

    public Person getPerson(String name) {
        Person person = null;
        Iterator<Person> iter = this.people.iterator();
        while (iter.hasNext()) {
            Person otherPerson = iter.next();
            if (otherPerson.getName().equals(name)) {
                person = otherPerson;
                break;
            }
        }

        return person;
    }

    @Override
    public void personJoinsGroup(String name1, String name2) {
        Person person1 = getPerson(name1);
        Person person2 = getPerson(name2);
        LandMark landmark = person2.getCurrLandmark();

        landmark.joinGroup(person1, person2);
    }

    @Override
    public boolean isAtSameGroup(String name1, String name2) {
        Person person1 = getPerson(name1);
        Person person2 = getPerson(name2);
        Group group1 = person1.getCurrGroup();
        Group group2 = person2.getCurrGroup();
        return group1 == group2;
    }

    @Override
    public Iterator<Person> listAllPeopleInGroup(String name) {
        return getPerson(name).getCurrGroup().listAllPeople();
    }

    @Override
    public int getAmountOfGroupsByLandmark(String landmark) {
        LandMark place = getLandMark(landmark);
        return place.getAmountOfGroups();
    }

    @Override
    public Iterator<Group> listAllGroups(String landmark) {
        return getLandMark(landmark).listAllGroups();
    }

    @Override
    public boolean isLandmarkEmpty(String landmark) {
        LandMark place = getLandMark(landmark);
        return place.getOccupation() == 0;
    }

    @Override
    public boolean isPersonAlone(String name) {
        return getPerson(name).isAlone();
    }

    @Override
    public void isolatePerson(String name) {
        Person person = getPerson(name);
        LandMark landmark = person.getCurrLandmark();
        landmark.isolate(person);
    }

	@Override
	public void startGossip(Gossip gossip, Person person) {
		gossips.insertLast(gossip);
        if(person.getType().equals("forgetful") && person.getGossips().size() == person.getCapacity()) {
            person.getGossips().removeAt(0);
            person.getGossips().insertLast(gossip);
        } else {
            person.getGossips().insertLast(gossip);
        }
	}

	@Override
	public Iterator<Gossip> gossip(String name) {
		Person person = getPerson(name);
        Group group = person.getCurrGroup();
        Iterator<Person> personsToShare = group.listAllPeople();
        Iterator<Gossip> gossipsToShare = person.getGossipsToShare();
        while(personsToShare.hasNext()) {
            Person curPerson = personsToShare.next();
            if(curPerson != person) {
                while(gossipsToShare.hasNext()) {
                    curPerson.listenGossip(gossipsToShare.next());        
                }
                gossipsToShare.rewind();
            }
        }
		
        return gossipsToShare;
	}


    @Override
    public boolean personKnowsNothing(String name) {
        Person person = getPerson(name);
        return person.getNumOfGossips() == 0;
    }


    @Override
    public boolean isPersonAbleToShareAGossip(String name) {
        Person person = getPerson(name);
        return person.hasGossipsToShare();
    }

    @Override
    public boolean hasGossip(String owner, Array<Person> targets, String gossipString) {
        Person ownerPerson = getPerson(owner);
        Gossip gossip = new GossipClass(ownerPerson, targets, gossipString);

        for(int i = 0; i < gossips.size(); i++) {
            if(gossips.get(i).equals(gossip)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Array<Gossip> getGossipsAboutPerson(String name) {
        Person person = getPerson(name);
        Array<Gossip> gossipsAboutPerson = new ArrayClass<>();
        
        for (int i = 0; i < gossips.size(); i++) {
            for (int j = 0; j < gossips.get(i).getTargets().size(); j++) {
                if(gossips.get(i).getTargets().get(j).equals(person)) {
                    gossipsAboutPerson.insertLast(gossips.get(i));
                }
            }   
        }

        return gossipsAboutPerson;
    }

    @Override
    public int getNumOfListeners(Gossip gossip) {
        int numOfListeners = 0;
        for(int i = 0; i < people.size(); i++) {
            for(int j = 0; j < people.get(i).getGossips().size(); j++) {
                if(people.get(i).getGossips().get(j).equals(gossip)) {
                    numOfListeners++;
                }
            }
        }

        return numOfListeners;
    }

    
}
