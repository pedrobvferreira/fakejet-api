package fakejet.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import fakejet.response.OneWayFakeJetResponse;

@FeignClient(name = "flights", url = "${url.fakejet}")
public interface FakejetClient {
	
	@GetMapping(value = "/search/flights", produces = "application/json")
	public OneWayFakeJetResponse getAllFlights(
			@RequestHeader(value = "X-Auth-Username", required = true) String authUser,
			@RequestHeader(value = "X-Auth-Password", required = true) String authPass,
			@RequestParam(value = "departureAirport", required = true) String departureAirport,
			@RequestParam(value = "arrivalAirport", required = true) String arrivalAirport, 
			@RequestParam(value = "departureDate", required = true) String departureDate);

}
