package model;

import java.util.Date;

public class Transaction {
    String accountNumber;
    double transactionAmount;
    Date transactionDate;

    public Transaction(String accountNumber, double transactionAmount, Date transactionDate) {
        this.accountNumber = accountNumber;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getTransactionAmount() {
        return this.transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return String.format("%-25s| %-25s| %-25s", this.accountNumber, this.transactionAmount, this.transactionDate);
    }

}
