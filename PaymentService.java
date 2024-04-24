package ooad.demo.service;
import ooad.demo.domain.CreditCard;
import ooad.demo.domain.DebitCard;
import ooad.demo.domain.Payment;
import org.springframework.stereotype.Service;
import ooad.demo.domain.PaymentMethod;


@Service
public class PaymentService {

    public boolean processPayment(Payment payment) {
        // Create the appropriate payment method based on the payment details
        PaymentMethod paymentMethod = createPaymentMethod(payment);

        if (paymentMethod != null) {
            // Process payment using the selected payment method
            return paymentMethod.processPayment(payment.getAmount());
        } else {
            // Handle unsupported payment method
            return false;
        }
    }

    // Factory method to create the appropriate PaymentMethod instance
    private PaymentMethod createPaymentMethod(Payment payment) {
        if ("Credit Card".equalsIgnoreCase(payment.getPaymentMethod())) {
            return new CreditCardPayment((CreditCard) payment);
        } else if ("Debit Card".equalsIgnoreCase(payment.getPaymentMethod())) {
            return new DebitCardPayment((DebitCard) payment);
        } else {
            // Unsupported payment method
            return null;
        }
    }
}


