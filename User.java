public class User {

    private String userName;
    private String userPassword;
    private int userScore;
    private int userWins;


    public User(String uName, String uPassword){//for new users created, sets username and password but sets score to 0
        this.userName = uName;
        this.userPassword = uPassword;
        this.userScore = 0;
        this.userWins = 0;
    }

    public User(String uName, String uPassword, int uScore, int totalWins){//for loading in users aka users signing in
        this.userName = uName;
        this.userPassword = uPassword;
        this.userScore = uScore;
        this.userWins = totalWins;
    }

    //solely used to load in users from the file
    public void setUserScore(int newUserScore){
        this.userScore = newUserScore;
    }

    //allows the user to change their password, or if they're creating a new password
    //if the password length is below 8, then return false, otherwise modify it and return true
    public Boolean changeUserPassword(String newPassword){
        if (newPassword.length() < 8){
            System.out.println("Passwords must be 8 characters or greater in length");
            return false;
        }
        this.userPassword = newPassword;
        return true;
    }

    //solely used to load in users from the file
    public void setUserWins(int newUserWins){
        this.userWins = newUserWins;
    }

    //used to fetch the users username
    public String getUserName(){
        return userName;
    }

    //to fetch get the users password
    public String getUserPassword(){
        return userPassword;
    }

    //used to fetch the users score in the game
    public int getUserScore(){
        return userScore;
    }

    //used to fetch the amount of games a player has won in their career
    public int getUserWins(){
        return userWins;
    }

    //solely used for the ingame context, if they win the round, they gain a point
    public void incrementUserScore(){
        userScore++;
    }

    //solely used for the ingame context, if they win the entire game, the userWins variable is incremented
    public void incrementUserWins(){
        userWins++;
    }

    //just a simple toString method to print the user seamlessly 
    public String toString() {
        return "User [userName=" + userName + ", userPassword=" + userPassword + ", userScore=" + userScore
                + ", userWins=" + userWins + "]";
    }

    
}


