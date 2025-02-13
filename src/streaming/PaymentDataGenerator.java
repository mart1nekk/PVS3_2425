package streaming;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Payment {
    private String transactionId;
    private String userId;
    private double amount;
    private LocalDateTime transactionDate;
    private String paymentMethod;
    private String status;
    private String category;

    public Payment(String transactionId, String userId, double amount, LocalDateTime transactionDate,
                   String paymentMethod, String status, String category) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.category = category;
    }


    public String getTransactionId() {
        return transactionId;
    }

    public String getUserId() {
        return userId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("Payment{ID=%s; User=%s; Amount=%.2f; Date=%s; Method=%s; Status=%s; Category=%s}",
                transactionId, userId, amount, transactionDate, paymentMethod, status, category);
    }

    public static List<Payment> generateSamplePayments(int count) {
        Random random = new Random();
        List<String> users = Arrays.asList("U001", "U002", "U003", "U004", "U005");
        List<String> paymentMethods = Arrays.asList("Credit Card", "Debit Card", "PayPal", "Bank Transfer");
        List<String> statuses = Arrays.asList("Completed", "Pending", "Failed");
        List<String> categories = Arrays.asList("Groceries", "Entertainment", "Utilities", "Travel", "Shopping");

        return IntStream.range(0, count).mapToObj(i -> new Payment(
                "TXN" + (1000 + i),
                users.get(random.nextInt(users.size())),
                10 + (500 * random.nextDouble()),
                LocalDateTime.now().minusDays(random.nextInt(30)),
                paymentMethods.get(random.nextInt(paymentMethods.size())),
                statuses.get(random.nextInt(statuses.size())),
                categories.get(random.nextInt(categories.size()))
        )).collect(Collectors.toList());
    }
}

public class PaymentDataGenerator {
    public static void main(String[] args) {
        List<Payment> payments = Payment.generateSamplePayments(100);
        payments.forEach(System.out::println);

        //vypsat vsechny Completed platby:
        payments.stream()
                .filter(payment -> payment.getStatus().equals("Completed"))
//                .forEach(payment -> System.out.println(payment.toString()));
                .forEach(System.out::println);
        System.out.println("---");
        //vsechny platby ve vysi alespon 200, vypsano serazeno dle data
        payments.stream()
                .filter(payment -> payment.getAmount() > 200)
//                .sorted((pay1, pay2) -> pay1.getTransactionDate().compareTo(pay2.getTransactionDate()))
                .sorted(Comparator.comparing(Payment::getTransactionDate))
                .forEach(System.out::println);

        //prumerna vyse platby pro uzivatele U003
        double averageUser = payments.stream()
                .filter(payment -> payment.getUserId().equals("U003"))
                .mapToDouble(Payment::getAmount)
                .average()
                .orElse(0);

        //Celkovy pocet plateb pro uzivatele U003
        int amount = (int) payments.stream()
                .filter(payment -> payment.getUserId().equals("U003"))
                .distinct()
                .count();
        System.out.println("prumerna vyse platby pro uzivatele U003: " + averageUser);
        System.out.println("Pocet plateb pro uzivatele U003: " + amount);

        //je alespon nejaka platba nad 400?
        System.out.println("je alespon nejaka platba nad 400?");
        System.out.println(payments.stream().anyMatch(payment -> payment.getAmount() > 400));


        double totalPending = payments.stream()
                .filter(payment -> payment.getStatus().equals("Pending"))
                .mapToDouble(Payment::getAmount)
                .sum();
        System.out.println("Celkova castka ceka na schvaleni: " + totalPending);
    }
}
