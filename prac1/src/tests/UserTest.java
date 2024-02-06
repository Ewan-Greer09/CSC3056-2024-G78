package tests;

import model.User;
import utils.TestUtils;

public class UserTest {
    public static void main(String[] args) {
        testUserConstructor();
    }

    public static void testUserConstructor() {

        String testUsername = "testUsername";
        String testPassword = "testPassword";
        String testFirstName = "testFirstName";
        String testLastName = "testLastName";
        String testMobileNumber = "testMobileNumber";

        User testUser = new User(testUsername, testPassword, testFirstName, testLastName, testMobileNumber);

        System.out.println("Test: User constructor");

        if (testUser.getUsername().equals(testUsername)) {
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername PASS: Username is correct"
                    + TestUtils.TEXT_COLOR_RESET);
        } else {
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername FAIL: Username is incorrect"
                    + TestUtils.TEXT_COLOR_RESET);
        }

        if (testUser.getPassword().equals(testPassword)) {
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getPassword PASS: Password is correct"
                    + TestUtils.TEXT_COLOR_RESET);
        } else {
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getPassword FAIL: Password is incorrect"
                    + TestUtils.TEXT_COLOR_RESET);
        }

        if (testUser.getFirstName().equals(testFirstName)) {
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getFirstName PASS: First name is correct"
                    + TestUtils.TEXT_COLOR_RESET);
        } else {
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getFirstName FAIL: First name is incorrect"
                    + TestUtils.TEXT_COLOR_RESET);
        }

        if (testUser.getLastName().equals(testLastName)) {
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getLastName PASS: Last name is correct"
                    + TestUtils.TEXT_COLOR_RESET);
        } else {
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getLastName FAIL: Last name is incorrect"
                    + TestUtils.TEXT_COLOR_RESET);
        }

        if (testUser.getMobileNumber().equals(testMobileNumber)) {
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC5-getMobileNumber PASS: Mobile number is correct"
                    + TestUtils.TEXT_COLOR_RESET);
        } else {
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC5-getMobileNumber FAIL: Mobile number is incorrect"
                    + TestUtils.TEXT_COLOR_RESET);
        }

        assert testUser.getUsername().equals(testUsername);
        assert testUser.getPassword().equals(testPassword);
        assert testUser.getFirstName().equals(testFirstName);
        assert testUser.getLastName().equals(testLastName);

        System.out.println("Test: User constructor completed");
    }
}
