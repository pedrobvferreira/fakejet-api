package fakejet.response;

import java.io.Serializable;
import java.util.List;

public class ReturnFakeJetResponse implements Serializable {

	private static final long serialVersionUID = 8031851814268683025L;
	
	private List<ReturnFlightResponse> flights;

	public List<ReturnFlightResponse> getFlights() {
		return flights;
	}

	public void setFlights(List<ReturnFlightResponse> flights) {
		this.flights = flights;
	}
	
}
