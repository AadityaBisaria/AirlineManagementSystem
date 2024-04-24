package ooad.demo.domain;
import java.util.Date;

public class Booking {
    private Long id;
    private User user;
    private Flight flight;
    private Date bookingDate;
    private int numOfPassengers;
    // Add more fields as needed

    // Constructors
    public Booking() {
    }

    public Booking(User user, Flight flight, Date bookingDate, int numOfPassengers) {
        this.user = user;
        this.flight = flight;
        this.bookingDate = bookingDate;
        this.numOfPassengers = numOfPassengers;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    // toString() method for debugging and logging
    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", user=" + user +
                ", flight=" + flight +
                ", bookingDate=" + bookingDate +
                ", numOfPassengers=" + numOfPassengers +
                '}';
    }
}
