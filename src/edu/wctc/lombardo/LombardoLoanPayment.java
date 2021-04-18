package edu.wctc.lombardo;

import java.io.Serializable;

/**
 * This is the class used by Lombardo Lending to represent a
 * customer's mortgage payment.
 */
public class LombardoLoanPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    private int accountNum;

    // Date in the form of [day, month, year]
    private int[] paymentDate;
    private double amount;

    public LombardoLoanPayment(int accountNum, int[] paymentDate, double amount) {
        this.accountNum = accountNum;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int[] getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(int[] paymentDate) {
        this.paymentDate = paymentDate;
    }
}
