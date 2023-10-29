/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brandtg.wonderland;

  /**
   * title: Wonderland
   * description: Alice in Wonderland themed scavenger hunt game
   * date: August 19, 2023
   * @Gabrielle Brandt 3641614
   * @1.0
   * @copyright 2001-2023  Gabrielle Brandt
   */

  /**
   * DOCUMENTATION...
   */
  /**
   *
   * Class:
   *
   * Your Class Name
   * describe your class ....
   *
   * Variables:
   * - list and describe instance and static variables
   *
   * Constructors:
   * - list and describe constructors
   *
   * Methods:
   * - list and describe instance and static methods
   *
   */
 

public class Room extends ThingHolder {
    //private String name, description;
    public int n, s, w, e;
    public Character character;
    
    public Room(String aName, String aDescription, int aN, int aS, int aW, int aE, ThingList tl, Character c){
        super(aName, aDescription, tl);
        
        n = aN;
        s = aS;
        w = aW;
        e = aE;
        character = c;
    }
   /* public String gettheName(){
        return thename;
    }
    public String gettheDescription(){
        return "This is " + thedescription;
    }*/
    //north
    public int getN(){
        return n;
    }
    public void setN(int aN){
        this.n=aN;
    }
    //south
    public int getS(){
        return s;
    }
    public void setS(int aS){
        this.s=aS;
    }
    //east
    public int getE(){
        return e;
    }
    public void setE(int aE){
        this.e=aE;
    }
    //west
    public int getW(){
        return w;
    }
    public void setW(int aW){
        this.w=aW;
    }
    
    public String describe() {
        String desc = String.format("%s. %s.",gettheName(), gettheDescription())
                 + "\nItems here:\n"+ getThings().describeThings();
        if (character != null){
                desc+="\nCharacters here:\n"+ character.getDescription();
        }else{
            desc += "\nNo characters here.";
        }
        
        return desc;
    }
}
