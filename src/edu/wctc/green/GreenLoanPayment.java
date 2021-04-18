package edu.wctc.green;

import java.io.Serializable;

/**
 * This is the class used by Green Financial, Inc. to represent
 * a customer's mortgage payment.
 */
public class GreenLoanPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    private String customerId;
    // Milliseconds since the epoch (1 Jan 1970)
    private long paymentDate;
    private float amount;

    public GreenLoanPayment(String customerId, long paymentDate, float amount) {
        this.customerId = customerId;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public long getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(long paymentDate) {
        this.paymentDate = paymentDate;
    }
}
