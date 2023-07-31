package fakejet.response;

import java.io.Serializable;

public class ReturnFlightResponse extends OneWayFlightResponse implements Serializable {

	private static final long serialVersionUID = 354839833332696931L;

	private String returnDepartureAirport;
	private String returnArrivalAirport;
	private String returnDepartureDateTime;
	private String returnFlightDesignator;
	private Integer returnAvailableSeats;
	private Double returnCost;

	public String getReturnDepartureAirport() {
		return returnDepartureAirport;
	}

	public void setReturnDepartureAirport(String returnDepartureAirport) {
		this.returnDepartureAirport = returnDepartureAirport;
	}

	public String getReturnArrivalAirport() {
		return returnArrivalAirport;
	}

	public void setReturnArrivalAirport(String returnArrivalAirport) {
		this.returnArrivalAirport = returnArrivalAirport;
	}

	public String getReturnDepartureDateTime() {
		return returnDepartureDateTime;
	}

	public void setReturnDepartureDateTime(String returnDepartureDateTime) {
		this.returnDepartureDateTime = returnDepartureDateTime;
	}

	public String getReturnFlightDesignator() {
		return returnFlightDesignator;
	}

	public void setReturnFlightDesignator(String returnFlightDesignator) {
		this.returnFlightDesignator = returnFlightDesignator;
	}

	public Integer getReturnAvailableSeats() {
		return returnAvailableSeats;
	}

	public void setReturnAvailableSeats(Integer returnAvailableSeats) {
		this.returnAvailableSeats = returnAvailableSeats;
	}

	public Double getReturnCost() {
		return returnCost;
	}

	public void setReturnCost(Double returnCost) {
		this.returnCost = returnCost;
	}

}
