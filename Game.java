import java.util.Scanner;
public class Game {
    
private Users users;  //call to users class so we can use its methods
private Scanner userScanner; //setting up our scanner for the users input
User currentPlayer;//for our current player that is playing


public Game(){//constructor

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
        
    }


void logIn(){//if password attempt == 5, delete account
    String uName;
    String uPassword;

    System.out.println("Please enter your username");
    System.out.print(">");
    uName = userScanner.next();

    System.out.println(" ");

   
    System.out.println("Please enter your password");
    System.out.print(">");
    uPassword = userScanner.next();

    if (users.findUser(uName) == null || !users.findUser(uName).getUserPassword().equals(uPassword)){
        System.out.println("An invalid password or username was entered, please try again");
        logIn();
        
    }
    else{
        currentPlayer = users.findUser(uName);
        System.out.println("Welcome " + currentPlayer.getUserName());

    }

}


public static void main(String[] args) {
    Game g = new Game();
    g.menuScreen();
}


}
