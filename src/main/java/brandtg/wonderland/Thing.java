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
   * Thing
   * Superclass for all things. This is the overarching class for many of the other classes
   * because this allowed the name and description variables to not need to be rewritten 
   * multiple times.
   *
   * Variables:
   * - private String thename;
   * - private String thedescription;
   *
   * Constructors:
   * - public Thing(): default constructor for Thing class (doesn't really do anything)
   * - public Thing(String aName, String aDescription): constructor that uses aName and aDescription
   *   as initializing variables
   *
   * Methods:
   * - public String gettheName(): getter method forr the name variable
   * - public void settheName (String aName): setter method for the name variable
   * - public String gettheDescription(): getter method for theDescription variable
   * - public void settheDescription(String aDescription): setter method for the description variable
   * - public String describe(): returns the name and description in string form
   *
   */
  /**
   *
   * Class:
   *
   * ThingList extends ArrayList<Thing> implements java.io.Serializable
   * describe your class ....
   *
   * Constructors:
   * - public String describeThings(): gets name and description of the things
   *
   * Methods:
   * - Thing thisOb (String aName): takes input and converts it to lower case
   */
  /**
   *
   * Class:
   *
   * class Item extends Thing
   * describe your class ....
   *
   * Variables:
   * - private int value: assigns a value to each item
   *
   * Constructors:
   * - public Item(String aName, String aDescription, int aValue): primary constructor for Item class
   *
   * Methods:
   * - public int getValue(): returns value of Item
   */

import java.util.*;
import java.io.*;
public class Thing {
    private String thename;
    private String thedescription;
    public Thing(){
        
    }
    public Thing(String aName, String aDescription) {
        
        this.thename= aName;
        this.thedescription = aDescription;
    }
    
    
    //Name property
    public String gettheName(){
        return thename;
    }
    public void settheName (String aName){
        this.thename = aName;
    }
    
    //Description property
    public String gettheDescription(){
        return thedescription;
    }
    public void settheDescription(String aDescription){
        this.thedescription = aDescription;
    } 
    
  
    
    //describe method
    public String describe(){
        return thename + " " + thedescription;
    }
    
}


class ThingList extends ArrayList<Thing> implements java.io.Serializable{

    public String describeThings() {
        String s = "";
        if (this.size() == 0){
            s = "none";
        }else{
            for (Thing t : this) {
                s = s + t.gettheName() + ": " + t.gettheDescription()+ "\n";
            }
        }
        return s;
    }    
    Thing thisOb (String aName) {
        Thing athing = null;
        String thingName = "";
        String aNameLowCase = aName.trim().toLowerCase();
        for (Thing t :this) {
            thingName = t.gettheName().trim().toLowerCase();
            if (thingName.equals(aNameLowCase)){
             athing = t;
            }
        }
        return athing;
    }
}



class Item extends Thing {
    private int value;
    public Item(String aName, String aDescription, int aValue){
        super(aName, aDescription);
        this.value = aValue;
                } 
    //only getter method, no setter because the value of each item will
    //remain constant, only set when the Item object is created.
    public int getValue() {
        return value;
    }
}


    

