package ooad.demo.service;

import ooad.demo.domain.PaymentMethod;
import ooad.demo.domain.CreditCard;

public class CreditCardPayment implements PaymentMethod {
    private final CreditCard creditCard;

    public CreditCardPayment(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public boolean processPayment(double amount) {
        return creditCard.processPayment(amount);
    }
}
