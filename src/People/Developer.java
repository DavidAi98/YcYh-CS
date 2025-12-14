/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package People;

/**
 *
 * @author ayc
 */
public class Developer extends Person{

    private String identity;
    private Scores scores;
    
    public Developer(String name,int experience,int[] options,int score){
        super(name,experience);
        this.scores = new Scores(options,score);
        this.identity = "developer";
    }
    public Developer(String name,int experience){
        super(name,experience);
        this.identity = "developer";
        this.scores = new Scores(null,-1);
        
    }
   
    public Scores getScores(){
        return scores;
    }

    public String getIdentity(){
        return "developer";
    }


    @Override
    public String toString(){
        return super.toString()+" identity: developer score:"+scores.getScore();
    }
}
