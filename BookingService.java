package ooad.demo.service;
import ooad.demo.domain.Flight;
import ooad.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ooad.demo.domain.Payment;


@Service
public class BookingService {

    @Autowired
    private PaymentService paymentService;

    // Method to book a flight
    public boolean bookFlight(Flight flight, User user,Payment payment) {
        // Perform booking logic...

        // Process payment for the booking using PaymentService
        boolean paymentSuccess = paymentService.processPayment(payment);

        // If payment is successful, proceed with booking
        if (paymentSuccess) {
            // Perform booking...
            return true;
        } else {
            return false;
        }
    }

    // Setter method for setting the payment service (dependency injection)
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
