package edu.wctc.read;

import edu.wctc.green.GreenLoanPayment;

import java.time.*;

public class GreenAdapter implements Payment {
    private GreenLoanPayment original;

    public GreenAdapter(GreenLoanPayment m) {
        original = m;
    }

    @Override
    public double getAmount() {
        return original.getAmount();
    }

    @Override
    public void setAmount(double amount) {
        original.setAmount((float) amount);
    }

    @Override
    public String getCustomerId() {
        return original.getCustomerId();
    }

    @Override
    public void setCustomerId(String customerId) {
        original.setCustomerId(customerId);
    }

    @Override
    public LocalDate getPaymentDate() {
        Instant inst = Instant.ofEpochMilli(original.getPaymentDate());
        return LocalDate.ofInstant(inst, ZoneId.of("-6"));
    }

    @Override
    public void setPaymentDate(LocalDate paymentDate) {
        original.setPaymentDate(paymentDate.toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.of("-6")));
    }
}
