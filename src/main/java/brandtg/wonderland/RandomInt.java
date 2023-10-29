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
   * RandomInt
   * This class generates a random integer between an inclusive min and max
   *
   * Variables:
   * - int min: lowest number in range
   * - int max: highest number in range
   *
   * Constructors:
   * - none, the one automatically made by java
   *
   * Methods:
   * - public static int genRand(int min, int max) : method used to randomly generate an integer
   *
   */
 


public class RandomInt {
    //generate random integer between min and max inclusive
    
    public static int genRand(int min, int max){
        
        
        int randInt = (int)(Math.random()* ((max+1) - min)) + min;
        
        return randInt;
        
}
}