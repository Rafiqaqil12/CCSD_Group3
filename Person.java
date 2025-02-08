/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author M.S.I
 */
public class Person {
    private String name;
    private int personId;


    public Person(String name, int personId){
        this.personId = personId;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getPersonId(){
        return personId;
    }


}
