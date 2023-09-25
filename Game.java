import java.util.Scanner;
import java.util.Random;
public class Game {
    
private Users users;  //call to users class so we can use its methods
private Scanner userScanner; //setting up our scanner for the users input
User currentPlayer;//for our current player that is playing
private String[] computerChoice;//array for our computer to pick from to battle the user
private int max_score = 0;
private Random rand;
private int computerScore = 0;


public Game(){//constructor
    rand = new Random();
    computerChoice =  new String[]{"rock","paper","scissors"};//initialising our array from which the computer will randomly pick from
    users = new Users();//initialising our users class
    userScanner = new Scanner(System.in); //initialising our scanner ready for users input

    System.out.println(" ");//whitespace
    System.out.println("Welcome to a generic Rock Paper Scissors game!");
    System.out.println(" ");//whitespace

}

void menuScreen(){//start of our menu that lets our user pick choices '1-4'
    int choice = 0;//for our users choice which we'll put into a switch statement

    System.out.println("1. Create new user.");
    System.out.println("2. Log in to existing user.");
    System.out.println("3. Display leaderboard");
    System.out.println("4. Exit");
    System.out.println(" ");

    System.out.println("Please pick from the options above '1-4'");
    System.out.print(">");
    choice = userScanner.nextInt();

      switch (choice) {
        case 1:
                createAccount();//calls the create account method that lets a user create their account
        break;

        case 2:
                logIn();//calls the login method below which lets the user log in to their already existing account
        break;

        case 3:
                users.getLeaderboard();//displays the leaderboard
        break;

        case 4: 
                System.out.println("Exiting system...");//if users choice is 4, we then exit the system
                System.exit(0);
         break;
      
        default:
                System.out.println("This is not a valid option, please pick from options 1-4.");
                System.out.print("\033[H\033[2J");  //to clear the output
                System.out.flush(); //to clear the output
                menuScreen();//calls the menu screen back so we can get the users input again
        break;
      }


}

//later implement an option to let them exit at any time they want during account creation
void createAccount(){//lets the user create a fresh account, has various validation checks for username and password
     String uName;//to store the username from the user
     String uPassword;//to store the password from the user

    System.out.println("Please enter a username");//prompts user
    System.out.print(">");
    uName = userScanner.next();//takes input

     while (users.findUser(uName) != null){//this while loop checks if the user already exists by calling findUser in the Users class, it then loops until username is unique
        System.out.println("A user with this username already exists, please enter a unique username");
         System.out.print(">");
        uName = userScanner.next();
    }

      System.out.println(" ");//for readability
    System.out.println("Username accepted.");
     System.out.println(" ");//for readability

    System.out.println("Please enter a password. (Restriction: Must at least be 8 characters)");//promts user to enter password 
    System.out.print(">");
    uPassword = userScanner.next();//takes input

    while (uPassword.length() < 8){//this while loop checks if the password length is < 8, if it is, it then loops until user enters a password length which is >= 8
        System.out.println(" ");//for readability
        System.out.println("Password is less than 8 characters, please try again");
        System.out.print(">");
        uPassword = userScanner.next();
    }

      System.out.println(" ");//for readability
    System.out.println("Password accepted.");
    System.out.println(" ");//for readability

    System.out.println("User successfully created.");//confirmation that account is successfully created after passing various checks

    //maybe do a flush here then call the actual game func

    currentPlayer = new User(uName, uPassword);//creates the user ready to play the game
    users.addPlayer(currentPlayer);//adds user to our lists of users, its official here
    users.savePlayers();//saves the user to the Players.txt file
    playGame();//then it'll call the playGame function which handles the logic of the game
        
    }


void logIn(){//prompts user to enter enter their login details and has various checks that the user actually exists and if their password is correct
    System.out.println(" ");
    String uName;//local variables to hold the username from the user to load the user object
    String uPassword;// local varuable to hold the password from the user to load the user object

    System.out.println("Please enter your username");//prompts user to enter their username
    System.out.print(">");
    uName = userScanner.next();//reads in the username from the user

    System.out.println(" ");//for readability

   
    System.out.println("Please enter your password");//promts the user to enter their password
    System.out.print(">");
    uPassword = userScanner.next();//reads in the password from the user

    if (users.findUser(uName) == null || !users.findUser(uName).getUserPassword().equals(uPassword)){//this checks if either the user doesn't exist or the password was wrong
        System.out.println(" ");
        System.out.println("An invalid password or username was entered, please try again");
        logIn();//promts them back to the login to try again
        
    }
    else{//otherwise if its correct, our current user is the one we just found from the findUser method in Users
        currentPlayer = users.findUser(uName);//we set the current player to the correct one
        playGame();//then it'll call the playGame function which handles the logic of the game
    }

}

void playGame(){//add spacing after user enters their choice and it shows the choice made by user and computer for readability + comments + changes

String userChoice;
String computersChoice;
System.out.print("\033[H\033[2J");  //to clear the output
System.out.flush(); //to clear the output
System.out.println("Welcome " + currentPlayer.getUserName());//we issue a welecome message to confirm that they've logged in successfully
System.out.println(" ");


System.out.println("Remember you can quit at any time by typing 'exit'");
System.out.println(" ");
System.out.println("Please enter your choice: 'rock' 'paper' 'scissors'");
System.out.println(" ");

do { 
   System.out.print(currentPlayer.getUserName() +  "> " );
    
    userChoice = userScanner.next().toLowerCase();//taking the users choice and converting it to lowercase to avoid any errors
    computersChoice = computerChoice[rand.nextInt(3)];//will select randomly for the array indexes of 0-2, which will randomly output either rock paper or scissors

    if (userChoice.equals("rock") && computersChoice.equals("scissors")){
        currentPlayer.incrementUserScore();
        System.out.println(currentPlayer.getUserName() + " picked " + userChoice + " |" +  " Computer picked " + computersChoice + " (" + currentPlayer.getUserName() + ": " +  currentPlayer.getUserScore() + " " + "Computer " +   computerScore + ")" );
    
    
    }
    else if (userChoice.equals("rock") && computersChoice.equals("paper")){
        computerScore++;
        System.out.println(currentPlayer.getUserName() + " picked " + userChoice + " |" +  " Computer picked " + computersChoice + " (" + currentPlayer.getUserName() + ": " +  currentPlayer.getUserScore() + " " + "Computer " +   computerScore + ")" );


    }
    else if(userChoice.equals("paper") && computersChoice.equals("scissors")){
        computerScore++;
        System.out.println(currentPlayer.getUserName() + " picked " + userChoice + " |" +  " Computer picked " + computersChoice + " (" + currentPlayer.getUserName() + ": " +  currentPlayer.getUserScore() + " " + "Computer " +   computerScore + ")" );


    }
    else if(userChoice.equals("paper") && computersChoice.equals("rock")){
        currentPlayer.incrementUserScore();
        System.out.println(currentPlayer.getUserName() + " picked " + userChoice + " |" +  " Computer picked " + computersChoice + " (" + currentPlayer.getUserName() + ": " +  currentPlayer.getUserScore() + " " + "Computer " +   computerScore + ")" );

    }
    else if(userChoice.equals("scissors") && computersChoice.equals("rock")){
        computerScore++;
        System.out.println(currentPlayer.getUserName() + " picked " + userChoice + " |" +  " Computer picked " + computersChoice + " (" + currentPlayer.getUserName() + ": " +  currentPlayer.getUserScore() + " " + "Computer " +   computerScore + ")" );


    }
    else if(userChoice.equals("scissors") && computersChoice.equals("paper")){
        currentPlayer.incrementUserScore();
        System.out.println(currentPlayer.getUserName() + " picked " + userChoice + " |" +  " Computer picked " + computersChoice + " (" + currentPlayer.getUserName() + ": " +  currentPlayer.getUserScore() + " " + "Computer " +   computerScore + ")" );


    }
    else if (userChoice.equals(computersChoice)){
    System.out.println(currentPlayer.getUserName() + " picked " + userChoice + " |" +  " Computer picked " + computersChoice + " (" + currentPlayer.getUserName() + ": " +  currentPlayer.getUserScore() + " " + "Computer " +   computerScore + ")" );

    
       
    }
  } while (!userChoice.equals("exit"));

  if (currentPlayer.getUserScore() > computerScore){
    System.out.println("Congratulations, you have won!");
    System.out.println(currentPlayer.getUserName() + ": " + currentPlayer.getUserScore() + " " + "Computer: " +   computerScore);
    currentPlayer.setUserScore(0);//setting to 0 so that the userScore goes back to 0 and can count their score in the game again should they wish to play again
    computerScore = 0;//setting to 0 so that the userScore goes back to 0 and can count their score in the game again should they wish to play again
  }
  else if (currentPlayer.getUserScore() > computerScore){
    System.out.println("Unlucky, you have lost");
    System.out.println(currentPlayer.getUserName() + ": " +  currentPlayer.getUserScore() + " " + "Computer: " +   computerScore);
    currentPlayer.setUserScore(0);//setting to 0 so that the userScore goes back to 0 and can count their score in the game again should they wish to play again
    computerScore = 0;//setting to 0 so that the userScore goes back to 0 and can count their score in the game again should they wish to play again
  }
  else{
    System.out.println("It was a draw!");
    System.out.println(currentPlayer.getUserName() + ": " +  currentPlayer.getUserScore() + " " + "Computer: " +   computerScore);
    currentPlayer.setUserScore(0);//setting to 0 so that the userScore goes back to 0 and can count their score in the game again should they wish to play again
    computerScore = 0;//setting to 0 so that the userScore goes back to 0 and can count their score in the game again should they wish to play again
  }

  
    //scanner here for user input
    //randomly select from array of ["rock","paper","scissors"]
    //if conditions
    //increment userwins at the end
    //increment userscore in realtime
     //make sure to update player at the end
    //make sure to saveplayers at the end
   

}

public static void main(String[] args) {
    Game g = new Game();
    g.menuScreen();
}


}
