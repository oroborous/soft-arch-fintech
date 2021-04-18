package edu.wctc.wisco.util;

import edu.wctc.green.GreenLoanPayment;
import edu.wctc.lombardo.LombardoLoanPayment;
import edu.wctc.wisco.WiscoLoanPayment;
import edu.wctc.wisco.Payment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Please ignore this utility class. It was used to generate sample data and
 * is not necessary for the lab.
 */
public class IgnoreMe {
    public static void generateGreenPayments() {
        List<GreenLoanPayment> greenPayments = new ArrayList<>();

        LocalDate now = LocalDate.now();
        LocalTime midnight = LocalTime.MIDNIGHT;
        ZoneOffset offset = ZoneOffset.of("-6");
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int monthsOffset = random.nextInt(12);
            int daysOffset = random.nextInt(31);

            String account = Character.valueOf((char) (random.nextInt(26) + 65)).toString() +
                    Character.valueOf((char) (random.nextInt(26) + 65)).toString() + "-";
            for (int j = 0; j < 5; j++) {
                account += random.nextInt(10);
            }

            float amount = random.nextInt(200000) / 100.0f + 500;

            long time = now.minusMonths(monthsOffset).minusDays(daysOffset).toEpochSecond(midnight, offset) * 1000;
            greenPayments.add(new GreenLoanPayment(account, time, amount));
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("green.obj"))) {
            oos.writeObject(greenPayments);
        } catch (IOException e) {
            System.out.println("Error creating Green Financial file");
            e.printStackTrace();
        }

    }

    public static void generateLombardoPayments() {
        List<LombardoLoanPayment> lombardoPayments = new ArrayList<>();

        LocalDate now = LocalDate.now();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int monthsOffset = random.nextInt(12);
            int daysOffset = random.nextInt(31);

            String account = "";
            for (int j = 0; j < 8; j++) {
                account += random.nextInt(10);
            }

            float amount = random.nextInt(200000) / 100.0f + 500;

            LocalDate date = now.minusMonths(monthsOffset).minusDays(daysOffset);
            int[] dmy = {date.getDayOfMonth(), date.getMonthValue(), date.getYear()};
            lombardoPayments.add(new LombardoLoanPayment(Integer.parseInt(account), dmy, amount));
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lombardo.obj"))) {
            oos.writeObject(lombardoPayments);
        } catch (IOException e) {
            System.out.println("Error creating Lombardo Lending file");
            e.printStackTrace();
        }

    }

    public static void generateWiscoPayments() {
        List<Payment> wiscoPayments = new ArrayList<>();

        LocalDate now = LocalDate.now();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int monthsOffset = random.nextInt(12);
            int daysOffset = random.nextInt(31);

            String account = random.nextInt(10) +
                    Character.valueOf((char) (random.nextInt(26) + 65)).toString() +
                    Character.valueOf((char) (random.nextInt(26) + 65)).toString() +
                    "-" + random.nextInt(10) + "-";
            for (int j = 0; j < 4; j++) {
                account += random.nextInt(10);
            }

            float amount = random.nextInt(200000) / 100.0f + 500;

            LocalDate date = now.minusMonths(monthsOffset).minusDays(daysOffset);
            wiscoPayments.add(new WiscoLoanPayment(account, date, amount));
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("wisco.obj"))) {
            oos.writeObject(wiscoPayments);
        } catch (IOException e) {
            System.out.println("Error creating Wisco Holdings file");
            e.printStackTrace();
        }

    }

}
