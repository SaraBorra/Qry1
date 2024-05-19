package controllers;

import entity.*;
import repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightResporitory flightResporitory;
    @GetMapping("/provision")
    public List<Flight> provisionFlights() {
        List<Flight> flights = new ArrayList<>();
        List<String> descriptions = Arrays.asList("Business Trip", "Vacation", "Family Visit", "Conference", "Holiday");
        List<String> airports = Arrays.asList("JFK", "LAX", "ORD", "ATL", "LHR", "CDG", "FRA", "DXB", "HND", "PEK");
        Random random = new Random();
        for(int i = 0; i < 50; i++) {
            Flight flight = new Flight(descriptions.get(random.nextInt(descriptions.size())),
                    airports.get(random.nextInt(airports.size())),
                    airports.get(random.nextInt(airports.size())));

            flights.add(flight);
        }

        return flightResporitory.saveAllAndFlush(flights);
    }

    @GetMapping("/retrieve")
    public List<Flight> retrieveFlights() {
        return flightResporitory.findAll();
    }

    @GetMapping("/byStatus")
    public List<Flight> retrieveByStatus(String status){
        return flightResporitory.findByStatus(FlightStatus.toString(status));
    }
}
