package src.test.java;
import org.junit.Test;

import src.main.Java.Login;
import src.main.Java.User;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void testUsernameFormat() {
        assertTrue(Login.checkUserName("kyl_1"));
        assertFalse(Login.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testPasswordComplexity() {
        assertTrue(Login.checkPasswordComplexity("Ch&&sec@ke99!"));
        assertFalse(Login.checkPasswordComplexity("password"));
    }

    @Test
    public void testRegistrationMessages() {
        User user1 = new User("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertEquals("User registered successfully.", Login.registerUser(user1));

        User user2 = new User("kyle!!!!!!", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", Login.registerUser(user2));


        User(user);
    }
}