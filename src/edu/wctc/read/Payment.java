package edu.wctc.read;

import java.time.LocalDate;

public interface Payment {
    double getAmount();

    String getCustomerId();

    LocalDate getPaymentDate();

    void setAmount(double amount);

    void setCustomerId(String customerId);

    void setPaymentDate(LocalDate paymentDate);
}
