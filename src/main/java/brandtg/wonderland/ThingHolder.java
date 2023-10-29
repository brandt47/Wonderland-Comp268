/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brandtg.wonderland;

/**
 *
 * @author gabri
 */
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
   * ThingHolder
   * This class extends thing and contains methods that allow other objects to
   * "hold" other objects
   *
   * Variables:
   * -private ThingList things = new ThingList();
   * - things = tl
   *
   * Constructors:
   * - public ThingHolder (String aName, String aDescription, ThingList tl){}
   *   this is the primary constructor for this class
   *
   * Methods:
   * - public ThingList getThings() : getter method for this class
   * - public void setThings(ThingList things) : setter method for this class
   *
   * 
   * 
   * Class:
   *
   * Actor
   * Holds the methods required for the main player of the game
   *
   * Variables:
   * - private Room theLocation; : used to set the location of the actor, where
   *   they are on the game map
   *
   * Constructors:
   * - public Actor(String aName, String aDescription, ThingList tl, Room aRoom)
   *   primary constructor for this subclass
   *
   * Methods:
   * - list and describe instance and static methods
   * - public void setLocation(Room aRoom): setter method for actor's location
   * - public Room getLocation(): getter method for actor's location
   * - public String describe(): returns getter methods for name and character description
   */
  

public class ThingHolder extends Thing{
    
    private ThingList things = new ThingList();
    
   
    
    public ThingHolder (String aName, String aDescription, ThingList tl){
        super(aName, aDescription);
        things =tl;
    }    
       
  
    
    public ThingList getThings() {
        return things;
    }
    public void setThings(ThingList things) {
        this.things = things;
    }
}

class Actor extends ThingHolder{
    private Room theLocation;
    
    public Actor(String aName, String aDescription, ThingList tl, Room aRoom){
        super(aName, aDescription, tl);
        this.theLocation = aRoom;
    }
    public void setLocation(Room aRoom){
        this.theLocation = aRoom;
    }
    
    public Room getLocation(){
        return this.theLocation;
    }
    
    public String describe(){
        return gettheName() + " is in "+ getLocation().describe();
    }
}

