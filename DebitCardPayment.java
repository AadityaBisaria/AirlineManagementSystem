package ooad.demo.service;
import ooad.demo.domain.PaymentMethod;
import ooad.demo.domain.DebitCard;

public class DebitCardPayment implements PaymentMethod {
    private final DebitCard debitCard;

    public DebitCardPayment(DebitCard debitCard) {
        this.debitCard = debitCard;
    }

    @Override
    public boolean processPayment(double amount) {
        return debitCard.processPayment(amount);
    }
}
