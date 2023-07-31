package fakejet.response;

import java.io.Serializable;
import java.util.List;

public class OneWayFakeJetResponse implements Serializable {

	private static final long serialVersionUID = 445777905925087634L;
	
	private List<OneWayFlightResponse> flights;

	public List<OneWayFlightResponse> getFlights() {
		return flights;
	}

	public void setFlights(List<OneWayFlightResponse> flights) {
		this.flights = flights;
	}
	
}
