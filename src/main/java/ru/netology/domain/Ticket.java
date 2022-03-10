package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter


public class Ticket implements Comparable<Ticket> {

    int id;
    int price;
    String departureAirport;
    String arrivalAirport;
    int travelTime;


    @Override
    public int compareTo(Ticket o) {
        return this.price - o.price;
    }

    public boolean matches(String departureAirport, String arrivalAirport) {
        return this.getDepartureAirport().equalsIgnoreCase(departureAirport) && this.getArrivalAirport().equalsIgnoreCase(arrivalAirport);
    }
}