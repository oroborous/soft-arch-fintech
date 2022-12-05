package edu.wctc.wisco;

import java.time.LocalDate;

public interface WiscoPayment {
    double getAmount();

    String getCustomerId();

    LocalDate getPaymentDate();

    void setAmount(double amount);

    void setCustomerId(String customerId);

    void setPaymentDate(LocalDate paymentDate);
}
