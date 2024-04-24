package ooad.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public abstract class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paymentMethod; // Cash, Credit Card, Debit Card
    private String cardNumber; // Only applicable for Credit Card and Debit Card payments
    private String cvv; // Only applicable for Credit Card and Debit Card payments
    private String fullName; // Full name of the cardholder
    private double amount;
    private Date paymentDate;

    // Constructors
    public Payment() {
    }
    public Payment(String paymentMethod, String cardNumber, String cvv, String fullName, double amount, Date paymentDate) {
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.fullName = fullName;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }
    public abstract boolean processPayment(double amount);
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public Date getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    protected boolean deductAmount(double amount) {
        if (this.amount >= amount) {
            this.amount -= amount; // Deduct the payment amount from the user's balance
            return true; // Payment successful
        } else {
            return false; // Insufficient balance
        }
    }
}
