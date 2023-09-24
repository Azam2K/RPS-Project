import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Users {
    private ArrayList<User> myUsers; // Arraylist to hold user objects, this will hold our players
    private Scanner passwordScanner; // this scanner will take input from the user to delete their account if they wish
    private Scanner fileScanner; // this scanner reads the players from the text file and places them into our myUsers arraylist which holds our players
    private File txtFile; //this is just initialising our text File holding our players
    private FileWriter saveUsers;

public Users(){//constructor
txtFile = new File("/Users/azam/Desktop/RPS-Project/Players.txt");//initialising our file so that it has our path and the scanner can read it
myUsers = new ArrayList<User>();//initialising our arraylist of players that we're holding
passwordScanner = new Scanner(System.in);//initialising our scanner from above


try {
    fileScanner = new Scanner(txtFile);//our scanner scans the txt file ready to be inputted into the list
    while (fileScanner.hasNext()){//loop for our scanner to constantly read from the file until its empty
        String username = fileScanner.next();//local variable to store the username from the file so it can get inputted into the list of our users
        String password = fileScanner.next();//local variable to store the password from the file so it can get inputted into the list of our users
        int score = fileScanner.nextInt();//local variable to store the score from the file so it can get inputted into the list of our users
        int wins = fileScanner.nextInt();//local variable to store the winx from the file so it can get inputted into the list of our users
        User importedUser = new User(username, password, score, wins);//finally creating a new user from a line of the file
        myUsers.add(importedUser);//the user being added to our list of users
    }
} catch (FileNotFoundException e) {
    System.out.println("File not found, please check your path is correct or if the file exists.");//if file doesn't exist, we say whats wrong
}
}

public Boolean addPlayer(User newUser){//searches the arraylist of players and checks if the name exists, if it doesn't add this new object to the arraylist of players
    for (int i = 0; i < myUsers.size(); i++){
       if(newUser.getUserName().toLowerCase().equals(myUsers.get(i).getUserName().toLowerCase())){
        return false;
       }
    }
    myUsers.add(newUser);
    return true;
}

public Boolean deletePlayer(User deleteUser){//allows the user to delete their account if they so wish, requires them to enter their password
    for (User i : myUsers){
        if (deleteUser.getUserName().toLowerCase().equals(i.getUserName().toLowerCase())){
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

public User findUser(String playerName){//finds a user in our players list, if it isn't found, it'll return null
    for (User i : myUsers){
        if (i.getUserName().equals(playerName)){
            return i;
        }
    }
    return null;
}

public void updatePlayer(User updatedUser){//updates the players stats and details if they change anything
    for (User i : myUsers){
        if (i.getUserName().toLowerCase().equals(updatedUser.getUserName().toLowerCase())){
            i.changeUserPassword(updatedUser.getUserPassword());
            i.setUserScore(updatedUser.getUserScore());
            i.setUserWins(updatedUser.getUserWins());
        }
    }
}

public void savePlayers(){//saves the players to the txt file using a filewriter. each variable is separated by a space so it can be read in fine aswell
    //filewriter
    try {
        saveUsers = new FileWriter(txtFile);
        for (User i : myUsers){
            saveUsers.write(i.getUserName() + " " + i.getUserPassword() + " " + i.getUserScore() + " " + i.getUserWins() + "\n");
        }
        saveUsers.close();
    } catch (IOException e) {
        System.out.println("Error saving to file: Either file doesn't exist or Path is invalid.");
    }
}

public void printPlayers(){//prints the players
    for (User i : myUsers){
        System.out.println(i);
    }
}

void getTop10Players(){//top 10 leaderboard
    //comparable, make a leaderboard, make it look cool

}

    
}
