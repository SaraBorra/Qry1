package repository;


import entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightResporitory extends JpaRepository<Flight, Long> {
    List<Flight> findByStatus(FlightStatus flightStatus);
}