package fakejet.utils;

import java.util.ArrayList;
import java.util.List;

import fakejet.response.OneWayFakeJetResponse;
import fakejet.response.OneWayFlightResponse;
import fakejet.response.ReturnFakeJetResponse;
import fakejet.response.ReturnFlightResponse;

public class ReturnFakeJetUtils {
	
	public static ReturnFakeJetResponse convertToReturnFlightResponse(OneWayFakeJetResponse oneWayFlighs, OneWayFakeJetResponse returnFlighs) {
		return getReturnFlights(oneWayFlighs.getFlights(), returnFlighs.getFlights());
	}
	
	private static ReturnFakeJetResponse getReturnFlights(List<OneWayFlightResponse> oneWayFlighs, List<OneWayFlightResponse> returnFlighs) {
		ReturnFakeJetResponse returnResponse = new ReturnFakeJetResponse();
		List<ReturnFlightResponse> flightsReturn = new ArrayList<>();
		for (OneWayFlightResponse flightOneWay : oneWayFlighs) {
			ReturnFlightResponse flightReturnResponse = convertOneWayFlightResponse(flightOneWay);
			
			for (OneWayFlightResponse returnFlight : returnFlighs) {
				convertReturnFlightResponse(flightReturnResponse, returnFlight);
			}
			flightsReturn.add(flightReturnResponse);
		}
		returnResponse.setFlights(flightsReturn);
		return returnResponse;
	}
	
	static ReturnFlightResponse convertOneWayFlightResponse(OneWayFlightResponse oneWayFligh) {
		ReturnFlightResponse flightReturnResponse = new ReturnFlightResponse();
		flightReturnResponse.setDepartureAirportIataCode(oneWayFligh.getDepartureAirportIataCode());
		flightReturnResponse.setArrivalAirportIataCode(oneWayFligh.getArrivalAirportIataCode());
		flightReturnResponse.setDepartureDateTime(oneWayFligh.getDepartureDateTime());
		flightReturnResponse.setAvailableSeats(oneWayFligh.getAvailableSeats());
		flightReturnResponse.setCost(oneWayFligh.getCost());
		flightReturnResponse.setFlightDesignator(oneWayFligh.getFlightDesignator());
		return flightReturnResponse;
	}
	
	static void convertReturnFlightResponse(ReturnFlightResponse flightReturnResponse, OneWayFlightResponse returnFlight) {
		flightReturnResponse.setReturnDepartureAirport(returnFlight.getDepartureAirportIataCode());
		flightReturnResponse.setReturnArrivalAirport(returnFlight.getArrivalAirportIataCode());
		flightReturnResponse.setReturnDepartureDateTime(returnFlight.getDepartureDateTime());
		flightReturnResponse.setReturnDepartureDateTime(returnFlight.getDepartureDateTime());
		flightReturnResponse.setReturnFlightDesignator(returnFlight.getFlightDesignator());
		flightReturnResponse.setReturnAvailableSeats(returnFlight.getAvailableSeats());
		flightReturnResponse.setReturnCost(returnFlight.getCost());
	}
}
