// DebitCard.java
package ooad.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DebitCard extends Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double balance; // Assuming the balance available on the card

    // Constructors
    public DebitCard() {
    }

    public DebitCard(double balance) {
        this.balance = balance;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Implement processPayment method for debit card
    @Override
    public boolean processPayment(double amount) {
        // Simulate validating the debit card number and CVV
        if (!isValidCardNumber(getCardNumber()) || !isValidCVV(getCvv())) {
            return false; // Invalid card details
        }

        // Simulate deducting the amount from the card balance
        balance -= amount;

        // Simulate logging the transaction
        System.out.println("Payment processed using debit card. Amount: " + amount);

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
