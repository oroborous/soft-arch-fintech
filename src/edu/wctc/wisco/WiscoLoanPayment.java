package edu.wctc.wisco;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * This is the class used by Wisco Holdings to represent a customer's
 * mortgage payment. Wisco Holdings has recently acquired Lombardo
 * Lending and Green Financial and must make its software accommodate
 * data from the other companies' existing applications.
 */
public class WiscoLoanPayment implements Serializable, WiscoPayment {
    private static final long serialVersionUID = 1L;
    private String customerId;
    private LocalDate paymentDate;
    private double amount;

    public WiscoLoanPayment(String customerId, LocalDate paymentDate, double amount) {
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
