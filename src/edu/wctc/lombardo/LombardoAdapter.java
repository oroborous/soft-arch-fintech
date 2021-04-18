package edu.wctc.lombardo;

import edu.wctc.wisco.Payment;

import java.time.LocalDate;

public class LombardoAdapter implements Payment {
    private LombardoLoanPayment original;


    public LombardoAdapter(LombardoLoanPayment m) {
        original = m;
    }

    @Override
    public double getAmount() {
        return original.getAmount();
    }

    @Override
    public String getCustomerId() {
        return Integer.toString(original.getAccountNum());
    }

    @Override
    public LocalDate getPaymentDate() {
        int[] origDate = original.getPaymentDate();
        return LocalDate.of(origDate[2], origDate[1], origDate[0]);
    }

    @Override
    public void setAmount(double amount) {
        original.setAmount(amount);
    }

    @Override
    public void setCustomerId(String customerId) {
        original.setAccountNum(Integer.parseInt(customerId));
    }

    @Override
    public void setPaymentDate(LocalDate paymentDate) {
        int[] date = {paymentDate.getDayOfMonth(), paymentDate.getMonthValue(), paymentDate.getYear()};
        original.setPaymentDate(date);
    }
}
