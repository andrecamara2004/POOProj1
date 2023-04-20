public abstract class PersonClass implements Person{

    private String name;


    public PersonClass(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }
    
    
    public abstract String getType();
}
