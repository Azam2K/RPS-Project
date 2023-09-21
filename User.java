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

    public void setUserScore(int newUserScore){
        this.userScore = newUserScore;
    }

    public Boolean changeUserPassword(String newPassword){
        if (newPassword.length() < 8){
            System.out.println("Passwords must be 8 characters or greater in length");
            return false;
        }
        this.userPassword = newPassword;
        return true;
    }

    public void setUserWins(int newUserWins){
        this.userWins = newUserWins;
    }

    public String getUserName(){
        return userName;
    }

    public String getUserPassword(){
        return userPassword;
    }

    public int getUserScore(){
        return userScore;
    }

    public int getUserWins(){
        return userWins;
    }

    public void incrementUserScore(){
        userScore++;
    }

    public void incrementUserWins(){
        userWins++;
    }

    public String toString() {
        return "User [userName=" + userName + ", userPassword=" + userPassword + ", userScore=" + userScore
                + ", userWins=" + userWins + "]";
    }

  //hello azam
    
}


