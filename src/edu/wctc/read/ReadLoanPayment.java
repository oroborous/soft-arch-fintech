package edu.wctc.read;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * This is the class used by Read Holdings to represent a customer's
 * mortgage payment. Read Holdings has recently acquired Lombardo
 * Lending and Green Financial and must make its software accommodate
 * data from the other company's existing applications.
 */
public class ReadLoanPayment implements Serializable, Payment {
    private static final long serialVersionUID = 1L;
    private String customerId;
    private LocalDate paymentDate;
    private double amount;

    public ReadLoanPayment(String customerId, LocalDate paymentDate, double amount) {
        this.customerId = customerId;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String getCustomerId() {
        return customerId;
    }

    @Override
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    @Override
    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}
