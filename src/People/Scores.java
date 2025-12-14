/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package People;

/**
 *
 * @author ayc
 */
public class Scores {
    private int[] options = new int[5];
    private int score;
    
    public Scores(int[] options,int score){
        this.options = options;
        this.score = score;
    }
    
    public void calScores(){
        int total=0;
        for(int i=0;i<options.length;i++){
            total+=options[i];
        }
        this.score = total;
    }
    
    public int[] getOptions(){
        return options;
    }

  
    public void setOptions(int[] x){
        this.options=x;
    }
    public int getScore(){
        return score;
    }
    
    
    
}
