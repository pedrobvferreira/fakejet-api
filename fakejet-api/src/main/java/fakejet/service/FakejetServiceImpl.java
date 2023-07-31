package fakejet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fakejet.client.FakejetClient;
import fakejet.response.OneWayFakeJetResponse;
import fakejet.response.ReturnFakeJetResponse;
import fakejet.utils.DateUtils;
import fakejet.utils.ReturnFakeJetUtils;

@Service
public class FakejetServiceImpl {
	
	private static final String USER = "pedro";
    private static final String PASS = "PbE7ffRK";
	
	@Autowired
	private FakejetClient client;

	
	public FakejetServiceImpl(FakejetClient client) {
		this.client = client;
	}
	
	public OneWayFakeJetResponse findOneWayFlights(String departure, String arrival, String departureDate) {

		OneWayFakeJetResponse flighs = client.getAllFlights(USER, PASS, departure, arrival, departureDate);
		
		return flighs;
	}
	
	public ReturnFakeJetResponse findReturnFlights(String departure, String arrival, String departureDate, long holidayDuration) {

		OneWayFakeJetResponse oneWayFlighs = client.getAllFlights(USER, PASS, departure, arrival, departureDate);
		
		String returnDate = DateUtils.addDaysToDate(departureDate, holidayDuration);
		OneWayFakeJetResponse returnFlighs = client.getAllFlights(USER, PASS, arrival, departure, returnDate);
		
		return ReturnFakeJetUtils.convertToReturnFlightResponse(oneWayFlighs, returnFlighs);
	}

}
