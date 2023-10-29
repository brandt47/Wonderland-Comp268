/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
   * Wonderland
   *
   * Purpose and Description:
   * Alice in Wonderland text based adventure game
   * Project 4, comp 268
   *
   *
   * Compiling and running instructions
   * Required: ....
   * Compile:  ....
   * Run:      ....
   *
   */
  /**
   *
   * Class:
   *
   * Wonderland
   * main class for this game
   *
   * Variables:
   * - BufferedReader in;
   * - String input;
   * - String output;
   *
   * Constructors:
   * - no constructor specified 
   *
   * Methods:
   * - public static void main(String[] args) throws IOException
   *   main method for this class
   *
   */
  /**
   * Program Testing
   * see program testing document
   */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Wonderland {
    public static void main(String[] args) throws IOException{
        BufferedReader in;
        String input;
        String output;
        Game game = new Game();
        in = new BufferedReader(new InputStreamReader(System.in));
        game.showIntro();
        do{
            System.out.print("> ");
            input = in.readLine();
            output = game.runCommand(input);
            System.out.println(output);
        }while (!"q".equals(input));
        
        
    }
}
