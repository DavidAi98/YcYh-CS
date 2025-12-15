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
    private Scores scores;
    private String identity;
    
    public User(String name,int experience,int[] options,int score){
        super(name,experience);
        this.scores = new Scores(options,score);
        this.identity = "user";
    }
    public User(String name,int experience){
        super(name,experience);
        this.identity = "user";
        this.scores = new Scores(null,-1);
        
    }
    

     public String getIdentity(){
        return "user";
    }

    public Scores getScores(){

        return scores;
    }
    
    @Override
    public String toString(){
        return super.toString()+" identity: user score:"+scores.getScore();
    }
}
