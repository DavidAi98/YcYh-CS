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
        private int[] options;
    private int score;
    private String identity;
    
    public Developer(String name,int experience,int[] options,int score){
        super(name,experience);
        this.options = options;
        this.score = score;
        this.identity = "developer";
    }
    public Developer(String name,int experience){
        super(name,experience);
        this.identity = "developer";
        this.options = new int[0];
        this.score = -1;
        
    }
    
    @Override
    public String toString(){
        return super.toString()+" identity: developer score:"+score;
    }
}
