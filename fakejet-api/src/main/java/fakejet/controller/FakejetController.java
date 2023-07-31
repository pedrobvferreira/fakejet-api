package fakejet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fakejet.response.OneWayFakeJetResponse;
import fakejet.response.ReturnFakeJetResponse;
import fakejet.service.FakejetServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/search")
public class FakejetController {
	
	@Autowired
    private FakejetServiceImpl service;
	
	@GetMapping(value = "/oneway-flights", produces = "application/json")
	@ApiOperation(value = "Returns a list of OneWay Flights.")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful FakeJetResponse availability response", response = OneWayFakeJetResponse.class),
            @ApiResponse(code = 400, message = "Invalid request error response."),
            @ApiResponse(code = 404, message = "Not Found.")
    })
	public ResponseEntity<OneWayFakeJetResponse> findOneWayFlights(
			@RequestParam(value = "departureAirport", required = true) String departureAirport,
			@RequestParam(value = "arrivalAirport", required = true) String arrivalAirport,
			@RequestParam(value = "departureDate", required = true) String departureDate) {
		OneWayFakeJetResponse fakeJetResponse = service.findOneWayFlights(departureAirport, arrivalAirport, departureDate);

		return ResponseEntity.status(HttpStatus.OK).body(fakeJetResponse);
	}
	
	@GetMapping(value = "/return-flights", produces = "application/json")
	@ApiOperation(value = "Returns a list of Return Flights.")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful FakeJetReturnResponse availability response", response = ReturnFakeJetResponse.class),
            @ApiResponse(code = 400, message = "Invalid request error response."),
            @ApiResponse(code = 404, message = "Not Found.")
    })
	public ResponseEntity<ReturnFakeJetResponse> findReturnFlights(
			@RequestParam(value = "departureAirport", required = true) String departureAirport,
			@RequestParam(value = "arrivalAirport", required = true) String arrivalAirport,
			@RequestParam(value = "departureDate", required = true) String departureDate,
			@RequestParam(value = "holidayDuration", required = true) long holidayDuration) {
		ReturnFakeJetResponse fakeJetReturnResponse = service.findReturnFlights(departureAirport, arrivalAirport, departureDate, holidayDuration);
		
		return ResponseEntity.status(HttpStatus.OK).body(fakeJetReturnResponse);
	}

}
