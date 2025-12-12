/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package People;

/**
 *
 * @author ayc
 */
public class User extends Person{
    private int[] options;
    private int score;
    private String identity;
    
    public User(String name,int experience,int[] options,int score){
        super(name,experience);
        this.options = options;
        this.score = score;
        this.identity = "user";
    }
    public User(String name,int experience){
        super(name,experience);
        this.identity = "user";
        this.options = new int[0];
        this.score = -1;
        
    }
    
    public void setScore(int score){
        this.score = score;
    }
    public void setOptions(int i,int x){
        this.options[i] = x;
    }
        public String getIdentity(){
        return "user";
    }
    public int[] getOptions(){
        return options;
    }
    
    @Override
    public String toString(){
        return super.toString()+" identity: user score:"+score;
    }
}
