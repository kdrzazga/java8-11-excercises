package org.kd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Flights {
    /*
    Utwórz kolekcją unikalnych lotów (każdy lot zawiera tylko lotnisko startowe i końcowe). Utwórz metodę, która pozwoli
     na wyszukiwanie lotów z przesiadką. Napisz prosty test sprawdzający poprawność Twojego rozwiązania.
     */

    private List<Flight> flights = List.of(new Flight("Pekin", "Warszawa"), new Flight("Warszawa", "Mediolan")
            , new Flight("Pekin", "Tokio"), new Flight("Tokio", "Mediolan"), new Flight("Tokio", "Warszawa"));

    public static void main(String[] args) {

        new Flights().flights();
    }

    void flights() {
        var flightChanges = findFlightChange("Pekin", "Mediolan");
        flightChanges.forEach(f -> System.out.println(f.from));
    }

    List<Flight> findFlightChange(String from, String to) {
        var flightsFrom = flights.stream().filter(flight -> from.equals(flight.from)).collect(Collectors.toList());
        var flightsTo = flights.stream().filter(flight -> to.equals(flight.to)).collect(Collectors.toList());

        var result = new ArrayList<Flight>();
        var iterator = flightsFrom.iterator();
        while (iterator.hasNext()) {
            result.addAll(flightsTo.stream().filter(flight -> flight.from.equals(iterator.next().to)).collect(Collectors.toList()));

        }
        return result;
    }

    class Flight {
        private String from;
        private String to;

        private Flight(String from, String to) {
            this.from = from;
            this.to = to;
        }


    }

    class PossibleChanges {
        public String changeCity;
        public String from;
        public String to;

        public PossibleChanges(String changeCity, String from,
                               String to) {
            this.changeCity = changeCity;
            this.from = from;
            this.to = to;
        }
    }

    private final List<PossibleChanges> possibleChanges = List.of(new PossibleChanges("Warszawa", "Moskwa", "Berlin"),
            new PossibleChanges("Pekin", "Wroclaw", "Toronto"));
}
