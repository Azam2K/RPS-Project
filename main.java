import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        
      Users u = new Users();
    
    User u1 = new User("scump", "pass");
    User u2 = new User("dashy", "password");
    User u3 = new User("pred", "password420");

    u.addPlayer(u1);
    u.addPlayer(u2);
    u.addPlayer(u3);

u3.changeUserPassword("password42000000");
u.updatePlayer(u3);



      u.printPlayers();

      u.savePlayers();

      u.printPlayers();

    //when loading a player in game class, i want to use find player and then set the current player to the object returned by the method, else say it doesnt exist
//in game class, give user option to play AI, set winning score and if they want to play friend but both need to be logged in
//try and introduce a wager system
//introduce gui
//introduce cool effects on win condition
//add feedback system


        
    }
}
