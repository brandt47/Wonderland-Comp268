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
   * Character
   * Class holds all the attributes of all the characters in the game. It also
   * hold an ArrayList that holds the character information imported from a text file.
   *
   * Variables:
   * - private String name;
   * - private String speech;
   *
   * Constructors:
   * - public Character(String charName, String charSpeech) : primary constructor
   *   for this class
   * 
   *
   * Methods:
   * - public String getname(): getter for character name
   * - public void setname(String charName): setter for character name
   * - public String getDescription(): returns the characters name and speech
   * - public String getspeech(): getter for character speech
   * - public void setspeech(String charSpeech): setter for character speech
   * - public String toString(): this method returns the name and speech of a character in
   *   type string
   * - public static ArrayList<Character> readCharactersFromFile(String fileName) 
   *   throws FileNotFoundException : This method imports the text file with the character
   *   information
   */
 



import java.io.*;
import java.util.*;

public class Character extends Thing{
private String name;
private String speech;



public Character(String charName, String charSpeech){
    this.name = charName;
    this.speech = charSpeech;
}
    public String getname(){
        return name;
    }
    public void setname(String charName){
        this.name = charName;
    }
    public String getDescription() {
        return this.getname() + ": " + this.getspeech()+ "\n";
    }    
    
    
    //Speech property
    public String getspeech(){
        return speech;
    }
    public void setspeech(String charSpeech){
        this.speech = charSpeech; 
} 
    public String toString(){
        return this.name + this.speech;
    }
    
   
    public static ArrayList<Character> readCharactersFromFile(String fileName) throws FileNotFoundException{
       fileName = "Characters.txt";
        File file = new File(fileName);
       Scanner s = new Scanner(file);
       ArrayList<Character> characterList = new ArrayList<Character>();
       
       while(s.hasNextLine()){
           String line = s.nextLine();
           
           String[] items = line.split(":");

           String charName = items[0];
           String charSpeech = items[1];
           
           Character newCharacter = new Character(charName, charSpeech);
           characterList.add(newCharacter);
           
           
       }
        
       
        return characterList;
    }



    
  
}

 
    
    
    
    
    







