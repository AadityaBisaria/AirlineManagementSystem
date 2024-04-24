package ooad.demo.service;

import ooad.demo.domain.Flight;
import ooad.demo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    // Method to add a new flight
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Method to retrieve all flights
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Method to retrieve a flight by ID
    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    // Method to update an existing flight
    public Flight updateFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Method to delete a flight by ID
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}
