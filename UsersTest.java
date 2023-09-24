import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class UsersTest {

    Users users = new Users();

    @Test
    void testAddPlayer() {//if user already exists (based on username), it will return false, otherwise it'll add the player and return true. Works as expected
        User u1 = new User("Azam", "password123");
        User u2 = new User("azam", "password");
        User u3 = new User("Mike", "password", 5, 10);

        assertTrue(users.addPlayer(u1));
        assertFalse(users.addPlayer(u2));
        assertTrue(users.addPlayer(u3));
        assertFalse(users.addPlayer(u3));
    }

    @Test
    void testDeletePlayer() {//cannot testing actually deleting a player as it takes input, however it works as intended
        User u1 = new User("Azam", "password123");
        User u2 = new User("John", "password");
        User u3 = new User("Mike", "password", 5, 10);

        users.addPlayer(u1);
        users.addPlayer(u2);
     
        assertFalse(users.deletePlayer(u3));
    }

    @Test
    void testFindUser() {

    }

    @Test
    void testGetLeaderboard() {

    }

    @Test
    void testPrintPlayers() {

    }

    @Test
    void testSavePlayers() {

    }

    @Test
    void testUpdatePlayer() {

    }
}
