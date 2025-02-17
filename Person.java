package CCSD_Project;

public class Person {
    private String name;
    private int personId;

    // Constructor for Person
    public Person(String name, int personId){
        this.personId = personId;
        this.name = name;
    }

    // Getter for name
    public String getName(){
        return name;
    }

    // Getter for personId
    public int getPersonId(){
        return personId;
    }
}
