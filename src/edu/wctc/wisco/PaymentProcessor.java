package edu.wctc.wisco;

import java.util.ArrayList;
import java.util.List;

public class PaymentProcessor {
    private List<Payment> paymentList = new ArrayList<>();

    public void addPayment(Payment payment) {
        paymentList.add(payment);
    }

    public double totalByMonth(int month) {
        return paymentList.stream().filter(p -> p.getPaymentDate().getMonthValue() == month)
                .mapToDouble(Payment::getAmount)
                .sum();
    }
}
