public class LandMarkClass implements LandMark{


    private int capacity;
    private String name;

    public LandMarkClass(int capacity, String name) {
        this.capacity = capacity;
        this.name = name;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getOccupation() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
