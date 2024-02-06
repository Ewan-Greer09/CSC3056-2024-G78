package model;

import java.util.Date;

public class Account {
    String accountNumber;
    String usernameOfAccountHolder;
    String accountType;
    Date accountOpeningDate;

    public Account(String accountNumber, String usernameOfAccountHolder, String accountType, Date accountOpeningDate) {
        this.accountNumber = accountNumber;
        this.usernameOfAccountHolder = usernameOfAccountHolder;
        this.accountType = accountType;
        this.accountOpeningDate = accountOpeningDate;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUsernameOfAccountHolder() {
        return this.usernameOfAccountHolder;
    }

    public void setUsernameOfAccountHolder(String usernameOfAccountHolder) {
        this.usernameOfAccountHolder = usernameOfAccountHolder;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getAccountOpeningDate() {
        return this.accountOpeningDate;
    }

    public void setAccountOpeningDate(Date accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    @Override
    public String toString() {
        return String.format("%-10s| %-30s| %-10s| %-15s", this.accountNumber, this.usernameOfAccountHolder,
                this.accountType, this.accountOpeningDate);
    }

}
