package fakejet.utils;

import java.util.ArrayList;
import java.util.List;

import fakejet.response.OneWayFakeJetResponse;
import fakejet.response.OneWayFlightResponse;

public class FakeJetSetUpUtil {

	public static OneWayFakeJetResponse getFakeJetResponse(String depart, String arrival, String date) {
		OneWayFakeJetResponse fakeJetResponse = new OneWayFakeJetResponse();
		
		List<OneWayFlightResponse> flights = new ArrayList<>();
		
		OneWayFlightResponse flightResponse1 = new OneWayFlightResponse();
		flightResponse1.setDepartureAirportIataCode(depart);
		flightResponse1.setArrivalAirportIataCode(arrival);
		flightResponse1.setDepartureDateTime(date);
		flightResponse1.setAvailableSeats(8);
		flightResponse1.setCost(385.54);
		flightResponse1.setFlightDesignator("LS671");
		flights.add(flightResponse1);
		
		fakeJetResponse.setFlights(flights);

        return fakeJetResponse;
    }
}
