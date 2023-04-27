import dataStructures.*;

public class GossipClass implements Gossip {

    private Person owner;
    private Array<Person> targets;
    private String gossip;
    private Array<Person> listeners;

    public GossipClass(Person owner, Array<Person> targets, String gossip) {
        this.owner = owner;
        this.targets = new ArrayClass<>(0);
        this.gossip = gossip;
        listeners = new ArrayClass<>();
    }

    public String getGossip() {
        return gossip;
    }

    @Override
    public Person getOwner() {
        return owner;
    }

    @Override
    public Iterator<Person> getTargetsIter() {
        return targets.iterator();
    }

    @Override
    public Iterator<Person> getListenersIter() {
        return listeners.iterator();
    }

    @Override
    public boolean isTargeting(Person person) {
        boolean check = false;
        for (int i = 0; i < targets.size(); i++) {
            if (targets.get(i) == person) {
                check = true;
                break;
            }
        }

        return check;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }

        GossipClass otherGossip = (GossipClass)obj;
        if(!this.getGossip().equals(otherGossip.getGossip())) {
            return false;
        } 

        if(this.getOwner() != otherGossip.getOwner()) {
            return false;
        }


        if(this.targets.size() != otherGossip.targets.size()) {
            return false;
        }

        for(int i = 0; i < this.targets.size(); i++) {
            if(!otherGossip.isTargeting(this.targets.get(i))) {
                return false;
            }
        }

        return true;
    }
}
