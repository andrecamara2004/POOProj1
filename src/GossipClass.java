import dataStructures.*;

public class GossipClass implements Gossip {

    private Person owner;
    private Array<Person> targets;
    private String gossip;
    private int shares;

    public GossipClass(Person owner, Array<Person> targets, String gossip) {
        this.owner = owner;
        this.targets = targets;
        this.gossip = gossip;
        this.shares = 0;
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

    @Override
    public Array<Person> getTargets() {
        return targets;
    }

    @Override
    public void registerShare() {
        shares++;
    }

    @Override
    public int getShares() {
        return shares;
    }

    @Override
    public void setSharesToZero() {
        shares = 0;
    }
}