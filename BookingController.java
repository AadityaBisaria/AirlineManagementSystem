package ooad.demo.controller;
import ooad.demo.domain.Booking;
import ooad.demo.domain.Flight;
import ooad.demo.domain.User;
import ooad.demo.service.BookingService;
import ooad.demo.service.FlightService;
import ooad.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BookingController {

    private final BookingService bookingService;
    private final FlightService flightService;
    private final PaymentService paymentService;

    @Autowired
    public BookingController(BookingService bookingService, FlightService flightService, PaymentService paymentService) {
        this.bookingService = bookingService;
        this.flightService = flightService;
        this.paymentService = paymentService;
    }
    @PostMapping("/bookFlight")
    public String bookFlight(@RequestBody BookingRequest bookingRequest) {
        // Retrieve flight details from the database
        Flight flight = flightService.getFlightById(bookingRequest.getFlightId())
                .orElseThrow(() -> new RuntimeException("Flight not found"));
    
        // Create a booking object
        Booking booking = new Booking();
        booking.setUser(bookingRequest.getUser());
        booking.setFlight(flight);
        booking.setBookingDate(new Date());
        booking.setNumOfPassengers(bookingRequest.getNumOfPassengers());
        // Process payment for the booking
        boolean isPaymentSuccessful = paymentService.processPayment(bookingRequest.getPayment());
        
        if (isPaymentSuccessful) {
            // If payment is successful, proceed with booking
            boolean isBookingSuccessful = bookingService.bookFlight(flight, bookingRequest.getUser(), bookingRequest.getPayment());
            if (isBookingSuccessful) {
                return "Booking successful!";
            } else {
                return "Booking failed!";
            }
        } else {
            return "Payment failed!";
        }
    }
    
}
