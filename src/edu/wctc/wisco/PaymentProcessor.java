package edu.wctc.wisco;

import java.util.ArrayList;
import java.util.List;

public class PaymentProcessor {
    private final List<WiscoPayment> wiscoPaymentList = new ArrayList<>();

    public void addPayment(WiscoPayment wiscoPayment) {
        wiscoPaymentList.add(wiscoPayment);
    }

    public double totalByMonth(int month) {
        return wiscoPaymentList.stream()
                .filter(p -> p.getPaymentDate().getMonthValue() == month)
                .mapToDouble(WiscoPayment::getAmount)
                .sum();
    }
}
