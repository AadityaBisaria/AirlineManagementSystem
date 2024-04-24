package ooad.demo.repository;
import  ooad.demo.domain.Flight;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    // You can define additional methods here if needed
}