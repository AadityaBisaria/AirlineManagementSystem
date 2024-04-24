package ooad.demo.controller;

import ooad.demo.domain.User;
import ooad.demo.domain.Payment; // Import Payment class

public class BookingRequest {
    private Long flightId;
    private User user;
    private Payment payment; // Add Payment attribute
    private int numOfPassengers;

    // Getters and setters

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() { // Getter for Payment
        return payment;
    }

    public void setPayment(Payment payment) { // Setter for Payment
        this.payment = payment;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }
}
