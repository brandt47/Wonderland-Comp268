/* THIS IS MY CONTROL CLASS
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
   * Game
   * This class holds all the 'control' methods needed for each game. 
   *
   * Variables:
   * - private ArrayList<Room> map;
   * - private Actor player;
   * - player = new Actor
   * 
   *
   * Constructors:
   * - public Game() throws IOException : constructor holds everything in this class
   *
   * Methods:
   * - private ArrayList getMap(): creates a new instance of the map ArrayList
   * - private void setMap(ArrayList<Room> aMap): map variable = aMap in this instance
   * - public Actor getPlayer() : getter method for main player of that game
   * - public void setPlayer(Actor aPlayer): setter method for main player of that game
   * - private void transferOb(Thing item, ThingList fromlist, ThingList tolist):  to move items from one
   *    list to another (ie from the rooms thinglist to the inventory thinglist)
   * - private String takeOb(String obname): method for the action of "take"
   * - private String dropOb(String obname): method for the action of "drop"
   * - private void moveActorTo(Actor p, Room aRoom): method to move the actor to a new room
   * - private int moveTo(Actor anActor, Direction dir) : contains switch that has cases for each direction
   * - private void movePlayerTo(Direction dir): method to specify which direction the character moves
   * - private void goN(): method that specifies to move to the north direction
   * - private void goW(): method that specifies to move to the west direction
   * - private void goE(): method that specifies to move to the east direction
   * - private void goS(): method that specifies to move to the south direction
   * - private void look(): method that will return the room and room description where the character currently is
   * - private void showMap(): method will print out game map
   * - private void showStr(String s): method will print out string that is set equal to s
   * - private void showInventory(): method will print out all the items and their descriptions in the inventory
   * - public void gameCompleted(): method checks that the end game requirements have been fulfilled, and ends the game
   *   if they have, if they haven't been fulfilled then it prints out "You still have items you need to find."
   * - public String processVerb(String verb): has a switch that has cases for all allowed verbs (and the methods to complete
   *   when the verb is inputted)
   * - public String processVerbNoun(ArrayList<String> wordlist): specifies verbs that can be used with nouns (take and drop)
   * - public String parseCommand(ArrayList<String> wordlist): allows only 2 word commands, will ignore word "go" if it is index 0
   * - public static ArrayList<String> wordList(String input): makes a wordlist
   * - public void showIntro(): this prints out the intro and instructions on how to play the game
   * - public String runCommand(String inputstr): switches input to all be lower case. Allows user
   *   to quit program if they enter q. Prompts user to enter a command if they just enter a space or nothing at all.
   */
 


import java.util.*;
import java.io.*;
public class Game {
    private ArrayList<Room> map;  //the map - an ArrayList of Rooms
    private Actor player; //the player - will give first person perspective
    ArrayList<String> objects = new ArrayList<>(Arrays.asList("sword", "watch", "mushroom",
            "hat", "crown", "teacup", "teapot", "rose", "cake", "acorn",
            "rock", "ribbon", "diamond", "flower", "potion"));
    
    
    
    
    public Game() throws IOException{
        
        this.map = new ArrayList<Room>();
        //items present in Rabbit hole (none)
        ThingList rabbitHoleItems = new ThingList();
        //items present in Northern Forest
        ThingList northForestItems = new ThingList();
        northForestItems.add(new Item("flower", "A beautiful (but common) flower", 1));
        northForestItems.add(new Item("mushroom", "Could be safe or could be poisonous", 2));
        
        ThingList southForestItems = new ThingList();
        southForestItems.add(new Item("hat", "Looks like this hat could belong to the Mad Hatter", 100));
        southForestItems.add(new Item("ribbon", "Your lost hair ribbon", 1));
        southForestItems.add(new Item("acorn", "Must have fallen off a tree", 1));
        
        ThingList whiteRabbitsHouseItems = new ThingList();
        whiteRabbitsHouseItems.add(new Item("crown", "A crown trimmed with fur and covered with rubies.", 150));
        whiteRabbitsHouseItems.add(new Item("rock", "A random rock", 1));
        
        ThingList teaPartyItems = new ThingList();
        teaPartyItems.add(new Item("sword", "Has engraving \"property of The Queen\"", 150));
        teaPartyItems.add(new Item ("cake", "This is covered in icing and looks delicious", 2));
        teaPartyItems.add(new Item("teacup", "An empty teacup", 2));
        
        ThingList redQueensCastleItems = new ThingList();
        redQueensCastleItems.add(new Item("diamond", "Sparkles very brightly", 2));
        redQueensCastleItems.add(new Item("potion", "Has a label that says \"If you're truly insane and want to leave, this will transport you out of Wonderland\"", 500));
        redQueensCastleItems.add(new Item("watch", "a golden watch", 100));
        
        ThingList redQueensGardenItems = new ThingList();
        redQueensGardenItems.add(new Item("teapot", "A pot of steaming hot tea", 50));
        redQueensGardenItems.add(new Item("rose", "A white rose that has been painted red",1));
        
        //CharList listOfAllCharacters = new CharList();
        //listOfAllCharacters.add(new Character("hello", "jh"));
        
       ArrayList<Character> charactersReadFromFile = Character.readCharactersFromFile("Characters.txt") ;
        

        ThingList playerInventory = new ThingList();
        if (playerInventory.contains("flower")){
            System.out.println("You've collected all the items and they will be returned to their owners!");
            System.exit(0);
        }
       // playerInventory.add(new Item("apple", "juicy", 1));
        //add rooms to the map
        //                    Room(name,                description,                                N,                   S,                   W,                   E)
        map.add(new Room("Rabbit Hole", "A mysterious hole in the ground.",          Direction.NOEXIT, 1,                Direction.NOEXIT, Direction.NOEXIT, 
                                                rabbitHoleItems, null));
        map.add(new Room("North Forest", "The northern side of the forest.",         Direction.NOEXIT, 2,                3,                6, 
                                                northForestItems, charactersReadFromFile.get(RandomInt.genRand(0,5))));
        map.add(new Room("South Forest", "The southern side of the forest.",         1,                Direction.NOEXIT, 4,                -1, 
                                                southForestItems, charactersReadFromFile.get(RandomInt.genRand(0,5))));
        map.add(new Room("White Rabbit's House", "Home of the White Rabbit.",        Direction.NOEXIT, 4,                Direction.NOEXIT, 1, 
                                                whiteRabbitsHouseItems, charactersReadFromFile.get(RandomInt.genRand(0,5))));
        map.add(new Room("Tea Party", "The location of the Mad Tea Party.",          Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 2, 
                                                teaPartyItems, charactersReadFromFile.get(RandomInt.genRand(0,5))));
        map.add(new Room("Red Queen's Castle", "The Castle is painted fully red.",   Direction.NOEXIT, Direction.NOEXIT, 2,                Direction.NOEXIT, 
                                                redQueensCastleItems, charactersReadFromFile.get(RandomInt.genRand(0,5))));
        map.add(new Room("Red Queen's Garden", "The Queen's rose garden.",           Direction.NOEXIT, 5,                1,                Direction.NOEXIT, 
                                                redQueensGardenItems, charactersReadFromFile.get(RandomInt.genRand(0,5))));
            
        // create a player and place in room 0
        player = new Actor("Alice", "a loveable Alice",playerInventory, map.get(0));
    }
    
    

    //access methods
    //map
    private ArrayList getMap(){
        return map;
    }
    private void setMap(ArrayList<Room> aMap){
        map = aMap;
    }
    //player
    public Actor getPlayer() {
        return player;
    }
    public void setPlayer(Actor aPlayer){
        player = aPlayer;
    }
    
    //take and drop items
    private void transferOb(Thing item, ThingList fromlist, ThingList tolist) {
        fromlist.remove(item);
        tolist.add(item);
    }
    
    private String takeOb(String obname) {
        String retStr = "";
        Thing item = player.getLocation().getThings().thisOb(obname);
        if (obname.equals("")){
            obname = "nameless object"; //if no object is specified
        }
        if (item == null){
            retStr = "There is no "+ obname+ " here!";
        } else {
            transferOb(item, player.getLocation().getThings(), player.getThings());
            retStr = obname + " taken!";
        }
        return retStr;
    }
    
    private String dropOb(String obname){
        String retStr ="";
        Thing t = player.getThings().thisOb(obname);
        if (obname.equals("")){
            retStr = "Please specify an object to drop!";
        }else if (t == null) {
            retStr = "You don't have one of these in your inventory!";
        }else {
            transferOb(t, player.getThings(), player.getLocation().getThings());
            retStr = obname + " dropped!";
        }
        return retStr;
    }
    
    
    //move a Person (Alice) to a Room
    private void moveActorTo(Actor p, Room aRoom){
        p.setLocation(aRoom);
    }
    private int moveTo(Actor anActor, Direction dir){
        
        Room r = anActor.getLocation();
        int exit;
        
        switch (dir){
            case NORTH:
                exit = r.getN();
                break;
            case SOUTH:
                exit = r.getS();
                break;
            case EAST:
                exit = r.getE();
                break;
            case WEST:
                exit = r.getW();
                break;
            default:
                exit = Direction.NOEXIT; //no exit in the specified direction
                break;
    }
    if (exit != Direction.NOEXIT){
        moveActorTo(anActor, map.get(exit));
    }    
    return exit;
    }

    
 
    
    
    
private void movePlayerTo(Direction dir){
    //displays the constant that represents the room in its array or NOEXIT
    if (moveTo(player, dir) == Direction.NOEXIT) {
        showStr("No Exit!");
    } else {
        look();
    }
}
private void goN(){
    movePlayerTo(Direction.NORTH);
}

private void goS(){
    movePlayerTo(Direction.SOUTH);
}

private void goW(){
    movePlayerTo(Direction.WEST);
}

private void goE(){
    movePlayerTo(Direction.EAST);
}
private void look(){
    showStr("You are in the "+ getPlayer().getLocation().describe());
    
}
private void showMap(){
    System.out.println("           n    " );
    System.out.println("         w + e             Rabbit Hole");
    System.out.println("           s                     |    ");
    System.out.println("                                 V     ");
    System.out.println("White Rabbit's House <->   North Forest   <-> Red Queen's Garden");
    System.out.println("           |                     ^ |                  |  ");
    System.out.println("           v                     | v                  V  ");
    System.out.println("        Tea Party    -->   South Forest   <-- Red Queen's Castle");
}
private void showStr(String s) {
    System.out.println(s);
}

private void showInventory() {
    showStr("You have: \n"+ getPlayer().getThings().describeThings());
      
        
}

public void gameCompleted(){
    
    ArrayList<String> winnyThings = new ArrayList<String>(Arrays.asList("hat", "crown", "watch", "mushroom",
            "teapot", "potion", "ribbon"));
    Boolean everything = true;
        for (String winThing: winnyThings){
            Boolean hasThing = false;
            for(Thing playerThing: getPlayer().getThings()){
                if(winThing.equals(playerThing.gettheName())){
                    hasThing = true;
                    break;
                }
            }
            
            if(!hasThing) {
               everything = false;
               break;
            }
        }
    
    
        if(everything) {
            System.out.println("\nCongratulations! Your inventory contains: hat, crown, watch, mushroom, teapot, and potion."
                    + "\nYou've collected all the lost items and they will be returned to their owners!"
                    + "\nYou drink your potion and are transported back home..."
                    + "\nWonderland is forever in your debt!");
            System.exit(0);
            
        } else {
            System.out.println("You still have items you need to find!");
        }
        }


    public String processVerb(String verb){
        
            switch (verb){
                case "n":
                case "north":
                    goN();
                    break;
                case "s":
                case "south":
                    goS();
                    break;
                case "w":
                case "west":
                    goW();
                    break;
                case "e":
                case "east":
                    goE();
                    break;
                case "l":
                case "look":
                    look();
                    break;
                case "i":
                case "inventory":
                    showInventory();
                    break;
                case "m":
                case "map":
                    showMap();
                    break;
                case "check":
                case "c":
                    gameCompleted();
                    break;
                default:
                    return verb + " is not a valid verb.";
            }
        return "";
    }
    public String processVerbNoun(ArrayList<String> wordlist){
        String verb;
        String noun;
        verb = wordlist.get(0);
        noun = wordlist.get(1);
        if(!objects.contains(noun)) {
            return (noun + " is not a known noun!");
        }
            switch(verb) {
                case "take":
                    return takeOb(noun);
                    
                case "drop":
                    return dropOb(noun);
                    
                default:
                    return " Not a valid verb.";        
        }
    }
    
    public String parseCommand(ArrayList<String> wordlist) {
        String msg;
        if (wordlist.size() == 1){
            msg = processVerb(wordlist.get(0));
        }else if (wordlist.size() == 2){
            if (wordlist.get(0).equals( "go")){
                msg = processVerb(wordlist.get(1));
            }else{ 
            msg = processVerbNoun(wordlist);
            }
        }else {
            msg = "Only 2 word commands allowed!";
        }
        return msg;
    }
    public static ArrayList<String> wordList(String input){
        String delims = "[ \t,.:;?!\"']+";
        ArrayList<String> strlist = new ArrayList<>();
        String[] words = input.split(delims);
        
        for (String word : words) {
            strlist.add(word);
        }
        return strlist; 
    }
    public void showIntro(){
        String s;
        s = "You are wandering along and you see a white rabbit dash by you.\n"
                +"You decide to follow him and he scurries down a rabbit hole.\n"
                +"The hole looks particularly inviting and the rabbit was really \n"
                +"cute so you decide to crawl in after him. You lose your footing\n"
                + "and begin falling down. Your hair ribbon comes undone and is gone.\n"
                + "The ribbon is very important to you, you hope to find it.\n"
                + "As you are falling you realize a map has appeared in your pocket\n"
                +"\nWelcome to WONDERLAND!\n"
                +"\n The Cheshire cat has been wreaking havoc on the citizens of Wonderland!\n"
                +"\n Your goal is to collect the missing items. Pay attention to the characters'"
                +"\n speech for hints on the items that you need to collect.\n"
                +"\n Press c when you want to check if you've put all the items in your inventory!"
                +"\n Instructions:\n"
                +"\n c or check = check for found items"
                +"\n n,s,w,e to move in that direction"
                +"\n m or map = map of Wonderland"
                +"\n look or l = will tell you what room you are in"
                +"\n type \"take\" to pick-up and item"
                +"\n type \"drop\" to put-down an item"
                +"\n Enter s to continue or q to quit\n";
        
        showStr(s);
        look();
    }
    
     public String runCommand(String inputstr) {
        ArrayList<String> wordlist;
        String s = "Okay!";
        String lowstr = inputstr.trim().toLowerCase();
        if (!lowstr.equals("q")) {
            if(lowstr.equals("")){
                s = "Please enter a command";
            }else {
                wordlist = wordList(lowstr);
                s = parseCommand(wordlist);
            }
        }
        return s;
    }
    
}

