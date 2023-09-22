import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    private ArrayList<User> myUsers;
    Scanner passwordScanner;

public Users(){
myUsers = new ArrayList<User>();
passwordScanner = new Scanner(System.in);
//here i want to create a while loop that loads the arraylist with the info from the text file, keeps creating new objects with info from the file

//when loading a player in game class, i want to use find player and then set the current player to the object returned by the method, else say it doesnt exist
//in game class, give user option to play AI, set winning score and if they want to play friend but both need to be logged in
//try and introduce a wager system
//introduce gui
//introduce cool effects on win condition
//add feedback system
}

public Boolean addPlayer(User newUser){//searches the arraylist of players and checks if the name exists, if it doesn't add this new object to the arraylist of players
    for (int i = 0; i < myUsers.size(); i++){
       if(newUser.getUserName().equals(myUsers.get(i).getUserName())){
        return false;
       }
    }
    myUsers.add(newUser);
    return true;
}

public Boolean deletePlayer(User deleteUser){//maybe change this into the game class and have it as an option when the user is already logged in, just make them verify their password
    for (User i : myUsers){
        if (deleteUser.getUserName().equals(i.getUserName())){
            System.out.println("Please enter your password to make sure you want to delete this account");
            if(i.getUserPassword().equals(passwordScanner.next())){
                myUsers.remove(i);
                passwordScanner.close();
                return true;
            }
        }
    }
    passwordScanner.close();
    System.out.println("The user you're trying to delete doesn't exist");
    return false;
}

public User findUser(String playerName){
    for (User i : myUsers){
        if (i.getUserName().equals(playerName)){
            return i;
        }
    }
    return null;
}

public void updatePlayer(User updatedUser){
    for (User i : myUsers){
        if (i.getUserName().equals(updatedUser.getUserName())){
            i.changeUserPassword(updatedUser.getUserPassword());
            i.setUserScore(updatedUser.getUserScore());
            i.setUserWins(updatedUser.getUserWins());
        }
    }
}

public void savePlayers(){
    //filewriter

}

void getTop10Players(){
    //comparable, make a leaderboard, make it look cool

}

    
}
