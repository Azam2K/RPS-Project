import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        
      Users u = new Users();
      User u1 = new User("gfgf", "gdffg", 0, 0);
      u.printPlayers();

      System.out.println("-----------------------");
      u.addPlayer(u1);
      u.printPlayers();
    
   

    //when loading a player in game class, i want to use find player and then set the current player to the object returned by the method, else say it doesnt exist
//in game class, give user option to play AI, set winning score and if they want to play friend but both need to be logged in
//try and introduce a wager system
//introduce gui
//introduce cool effects on win condition
//add feedback system
//maybe add a winstreak to the user


        
    }
}
