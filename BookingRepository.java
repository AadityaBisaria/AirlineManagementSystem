package ooad.demo.repository;
import ooad.demo.domain.Booking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    // You can define additional methods here if needed
}