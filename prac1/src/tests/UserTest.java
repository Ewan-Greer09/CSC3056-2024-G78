package src.tests;

import src.model.User;

public class UserTest {
    public static void main(String[] args) {
        // Create a new user
        User testUser = new User("testUser", "testPassword", "testName", "testSurname", "testPhone");
        System.out.println(testUser.toString());
    }
}
