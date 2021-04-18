package edu.wctc;

import edu.wctc.green.GreenLoanPayment;
import edu.wctc.lombardo.LombardoLoanPayment;
import edu.wctc.read.GreenAdapter;
import edu.wctc.read.LombardoAdapter;
import edu.wctc.read.Payment;
import edu.wctc.read.PaymentProcessor;
import edu.wctc.read.util.IgnoreMe;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        IgnoreMe.generateGreenPayments();
        IgnoreMe.generateLombardoPayments();
        IgnoreMe.generateReadPayments();

        List<Payment> readPayments = readReadPayments();
        List<GreenLoanPayment> greenPayments = readGreenPayments();
        List<LombardoLoanPayment> lombardoPayments = readLombardoPayments();


        PaymentProcessor processor = new PaymentProcessor();

        for(Payment readPayment : readPayments) {
            processor.addPayment(readPayment);
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

    private static List<Payment> readReadPayments() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("read.obj"))) {
            return (List<Payment>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading Read Holdings file");
            e.printStackTrace();
        }

        return new ArrayList<>(); // return empty list on exception
    }


}
