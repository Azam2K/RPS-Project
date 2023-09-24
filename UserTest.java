import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserTest {

//in the context, 'u' and 'u2' are pre exisisting users. 'u3' is a new account, so it doesn't have a user score or wins because they're set to 0 as default

User u = new User("Azam", "password123", 5, 10);
User u2 = new User("Mike","Pass123",8,20);
User u3 = new User("John", "helloworld123");



@Test
public void testGetUser(){
/*
 This function is to test the usernames and userpasswords. All is functioning as intended
 */

//These are working as intended
assertEquals("Azam", u.getUserName());
assertNotEquals("wronguser",u2.getUserName());
assertEquals("John",u3.getUserName());

//Tested passwords and changing them, working as intended
assertEquals("password123",u.getUserPassword());

u.changeUserPassword("changedpassword123");
assertEquals("changedpassword123",u.getUserPassword());
assertNotEquals("password123",u.getUserPassword());


//This should return False because the length of our password is < 8 characters
assertFalse(u.changeUserPassword("short"));
//This should return False because the lengtth of our password is > 8 characters
assertTrue(u2.changeUserPassword("longerthan8"));


}
@Test
public void testUserScores(){
    /*
     This function is to test that the user scores and wins system is working correctly
     The user wins is how many games the user has won in their career
     The user score is a variable in the game that tracks their score, 1 round win = 1 + their current score
     They are all working as intended
     */
   

//first users score and win and set to 5 and 10, in this context, they're loaded in from the file
assertEquals(5,u.getUserScore());
assertEquals(10, u.getUserWins());


//initially both user scores and wins are set to 0 as they are new accounts
assertEquals(0,u3.getUserScore());
assertEquals(0,u3.getUserWins());
assertNotEquals(12, u3.getUserScore());
assertNotEquals(7,u3.getUserWins());


//first users score and wins are incremented by 1
u.incrementUserScore();
u.incrementUserWins();

//working as intended
assertEquals(6,u.getUserScore());
assertEquals(11,u.getUserWins());

//also working as intended
assertEquals(20,u2.getUserWins());


}

}
