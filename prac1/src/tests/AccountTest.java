package tests;

import model.Account;
import utils.TestUtils;
import java.util.Date;

public class AccountTest {
        public static void main(String[] args) {
                testAccountConstructor();
                testAccountSetters();
        }

        public static void testAccountSetters() {
                // create object with empty values
                Account testAccount = new Account("", "", "", null);

                String testAccountNumber = "testAccountNumber";
                String testUsernameOfAccountHolder = "testUsernameOfAccountHolder";
                String testAccoutnType = "testAccountType";
                Date testAccountOpeningDate = new Date();

                // set object fields with test values
                testAccount.setAccountNumber(testAccountNumber);
                testAccount.setUsernameOfAccountHolder(testUsernameOfAccountHolder);
                testAccount.setAccountType(testAccoutnType);
                testAccount.setAccountOpeningDate(testAccountOpeningDate);

                // test if the object fields are set correctly
                System.out.println("Test: Account setters");
                assert testAccount.getAccountNumber().equals(testAccountNumber) : TestUtils.TEXT_COLOR_RED
                                + "TC1-setAccountNumber FAIL: Account number is incorrect" + TestUtils.TEXT_COLOR_RESET;

                assert testAccount.getUsernameOfAccountHolder().equals(testUsernameOfAccountHolder)
                                : TestUtils.TEXT_COLOR_RED
                                                + "TC2-setUsernameOfAccountHolder FAIL: Username of account holder is incorrect"
                                                + TestUtils.TEXT_COLOR_RESET;

                assert testAccount.getAccountType().equals(testAccoutnType) : TestUtils.TEXT_COLOR_RED
                                + "TC3-setAccountType FAIL: Account type is incorrect" + TestUtils.TEXT_COLOR_RESET;

                assert testAccount.getAccountOpeningDate().equals(testAccountOpeningDate) : TestUtils.TEXT_COLOR_RED
                                + "TC4-setAccountOpeningDate FAIL: Account opening date is incorrect"
                                + TestUtils.TEXT_COLOR_RESET;

                System.out.println(TestUtils.TEXT_COLOR_GREEN + "All test cases passed" + TestUtils.TEXT_COLOR_RESET);

        }

        public static void testAccountConstructor() {

                String testAccountNumber = "testAccountNumber";
                String testUsernameOfAccountHolder = "testUsernameOfAccountHolder";
                String testAccoutnType = "testAccountType";
                Date testAccountOpeningDate = new Date();

                Account testAccount = new Account(testAccountNumber, testUsernameOfAccountHolder, testAccoutnType,
                                testAccountOpeningDate);

                System.out.println("Test: Account constructor");

                assert testAccount.getAccountNumber().equals(testAccountNumber) : TestUtils.TEXT_COLOR_RED
                                + "TC1-getAccountNumber FAIL: Account number is incorrect" + TestUtils.TEXT_COLOR_RESET;

                assert testAccount.getUsernameOfAccountHolder().equals(testUsernameOfAccountHolder)
                                : TestUtils.TEXT_COLOR_RED
                                                + "TC2-getUsernameOfAccountHolder FAIL: Username of account holder is incorrect"
                                                + TestUtils.TEXT_COLOR_RESET;

                assert testAccount.getAccountType().equals(testAccoutnType) : TestUtils.TEXT_COLOR_RED
                                + "TC3-getAccountType FAIL: Account type is incorrect" + TestUtils.TEXT_COLOR_RESET;

                assert testAccount.getAccountOpeningDate().equals(testAccountOpeningDate) : TestUtils.TEXT_COLOR_RED
                                + "TC4-getAccountOpeningDate FAIL: Account opening date is incorrect"
                                + TestUtils.TEXT_COLOR_RESET;

                System.out.println(TestUtils.TEXT_COLOR_GREEN + "All test cases passed" + TestUtils.TEXT_COLOR_RESET);
        }

}
