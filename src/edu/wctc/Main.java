package edu.wctc;

import edu.wctc.green.GreenLoanPayment;
import edu.wctc.lombardo.LombardoLoanPayment;
import edu.wctc.green.GreenAdapter;
import edu.wctc.lombardo.LombardoAdapter;
import edu.wctc.wisco.WiscoPayment;
import edu.wctc.wisco.PaymentProcessor;
import edu.wctc.wisco.util.IgnoreMe;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        IgnoreMe.generateGreenPayments();
        IgnoreMe.generateLombardoPayments();
        IgnoreMe.generateWiscoPayments();

        List<WiscoPayment> wiscoPayments = readWiscoPayments();
        List<GreenLoanPayment> greenPayments = readGreenPayments();
        List<LombardoLoanPayment> lombardoPayments = readLombardoPayments();


        PaymentProcessor processor = new PaymentProcessor();

        for(WiscoPayment wiscoPayment : wiscoPayments) {
            processor.addPayment(wiscoPayment);
        }

        for(GreenLoanPayment greenPayment : greenPayments) {
            // How can you add GreenLoanPayments to the PaymentProcessor?
            processor.addPayment(new GreenAdapter(greenPayment));
        }

        for(LombardoLoanPayment lombardoPayment : lombardoPayments) {
            // How can you add LombardoLoanPayments to the PaymentProcessor?
            processor.addPayment(new LombardoAdapter(lombardoPayment));
        }

        for (int i = 1; i < 13; i++) {
            System.out.printf("Month %d Total Payments: $%.2f %n", i, processor.totalByMonth(i));
        }

    }

    private static List<GreenLoanPayment> readGreenPayments() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("green.obj"))) {
            return (List<GreenLoanPayment>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading Green Financial file");
            e.printStackTrace();
        }

        return new ArrayList<>(); // return empty list on exception
    }

    private static List<LombardoLoanPayment> readLombardoPayments() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lombardo.obj"))) {
            return (List<LombardoLoanPayment>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading Lombardo Lending file");
            e.printStackTrace();
        }

        return new ArrayList<>(); // return empty list on exception
    }

    private static List<WiscoPayment> readWiscoPayments() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("wisco.obj"))) {
            return (List<WiscoPayment>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading Wisco Holdings file");
            e.printStackTrace();
        }

        return new ArrayList<>(); // return empty list on exception
    }


}
