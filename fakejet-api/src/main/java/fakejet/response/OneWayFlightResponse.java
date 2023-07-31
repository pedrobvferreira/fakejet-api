package fakejet.response;

import java.io.Serializable;

public class OneWayFlightResponse implements Serializable{
	
	private static final long serialVersionUID = -1180727990459283222L;
	
	private String departureAirportIataCode;
	private String arrivalAirportIataCode;
	private String departureDateTime;
	private String flightDesignator;
	private Integer availableSeats;
	private Double cost;

	public String getDepartureAirportIataCode() {
		return departureAirportIataCode;
	}

	public void setDepartureAirportIataCode(String departureAirportIataCode) {
		this.departureAirportIataCode = departureAirportIataCode;
	}

	public String getArrivalAirportIataCode() {
		return arrivalAirportIataCode;
	}

	public void setArrivalAirportIataCode(String arrivalAirportIataCode) {
		this.arrivalAirportIataCode = arrivalAirportIataCode;
	}

	public String getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(String departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public String getFlightDesignator() {
		return flightDesignator;
	}

	public void setFlightDesignator(String flightDesignator) {
		this.flightDesignator = flightDesignator;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

}
