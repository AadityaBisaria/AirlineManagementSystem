package ooad.demo.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import ooad.demo.domain.Payment;



@Entity
public class CreditCard extends Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;
    private String cvv;
    private String cardholderName;
    private double balance; // Assuming the balance available on the card

    // Constructors
    public CreditCard() {
    }

    public CreditCard(String cardNumber, String cvv, String cardholderName, double balance) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.cardholderName = cardholderName;
        this.balance = balance;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Implement processPayment method for credit card
    @Override
    public boolean processPayment(double amount) {
        // Simulate validating the credit card number and CVV
        if (!isValidCardNumber(cardNumber) || !isValidCVV(cvv)) {
            return false; // Invalid card details
        }

        // Simulate deducting the amount from the card balance
        balance -= amount;

        // Simulate logging the transaction
        System.out.println("Payment processed using credit card. Amount: " + amount);

        return true; // Payment successful
    }

    private boolean isValidCardNumber(String cardNumber) {
        // Simulate validation logic for card number
        // This could involve checking the card number format or consulting a database of valid card numbers
        return cardNumber != null && cardNumber.length() == 16; // Placeholder logic
    }

    private boolean isValidCVV(String cvv) {
        // Simulate validation logic for CVV
        // This could involve checking the CVV format or consulting a database of valid CVVs
        return cvv != null && cvv.length() == 3; // Placeholder logic
    }
}
