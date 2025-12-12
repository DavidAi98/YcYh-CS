/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package People;

/**
 *
 * @author ayc
 */
public class Person {
    private String name;
    private int experience;
    
    public Person(String name,int experience){
        this.name = name;
        this.experience = experience;
    }
    public String getName(){
        return name;
    }
    public int getExperience(){
        return experience;
    }
    public String toString(){
        return "Name: "+name+" Experience: "+experience;
    }
}
