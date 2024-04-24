package ooad.demo.controller;

import ooad.demo.domain.CreditCard;
import ooad.demo.domain.DebitCard;
import ooad.demo.domain.Payment;
import ooad.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/processPayment")
    public String processPayment(@RequestBody Payment payment) {
        boolean isPaymentSuccessful = paymentService.processPayment(payment);
        if (isPaymentSuccessful) {
            return "Payment successful!";
        } else {
            return "Payment failed!";
        }
    }

    @PostMapping("/processCreditCardPayment")
    public String processCreditCardPayment(@RequestBody CreditCard creditCard) {
        Payment payment = new Payment(creditCard.getPaymentMethod(), creditCard.getCardNumber(), creditCard.getCvv(), creditCard.getFullName(), creditCard.getAmount(), creditCard.getPaymentDate()) {
            @Override
            public boolean processPayment(double amount) {
                return creditCard.processPayment(amount);
            }
        };
        boolean isPaymentSuccessful = paymentService.processPayment(payment);
        if (isPaymentSuccessful) {
            return "Credit card payment successful!";
        } else {
            return "Credit card payment failed!";
        }
    }

    @PostMapping("/processDebitCardPayment")
    public String processDebitCardPayment(@RequestBody DebitCard debitCard) {
        Payment payment = new Payment(debitCard.getPaymentMethod(), debitCard.getCardNumber(), debitCard.getCvv(), debitCard.getFullName(), debitCard.getAmount(), debitCard.getPaymentDate()) {
            @Override
            public boolean processPayment(double amount) {
                return debitCard.processPayment(amount);
            }
        };
        boolean isPaymentSuccessful = paymentService.processPayment(payment);
        if (isPaymentSuccessful) {
            return "Debit card payment successful!";
        } else {
            return "Debit card payment failed!";
        }
    }
}
