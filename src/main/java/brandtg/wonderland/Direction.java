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
   * public enum Direction
   * Sets the direction variables
   *
   * Variables:
   * - NORTH
   * - SOUTH
   * - EAST
   * - WEST
   * - public static final in NOEXIT = -1
   */
  

public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;
    /* NOEXIT has an integer value which was used when initializing
    the exit field in Room objects. -1 is equal to NOEXIT while all valid
    exists indicate a Room number
    */
    public static final int NOEXIT = -1;
};
