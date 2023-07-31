package fakejet.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;

import fakejet.client.FakejetClient;
import fakejet.response.OneWayFakeJetResponse;
import fakejet.response.ReturnFakeJetResponse;
import fakejet.utils.FakeJetSetUpUtil;

@ActiveProfiles(profiles = "tests")
class FakejetServiceImplTest {
	
	private FakejetClient fakejetClientMock;
	
	private FakejetServiceImpl fakejetServiceImpl;
	
	private static final String USER = "pedro";
    private static final String PASS = "PbE7ffRK";
	
	@BeforeEach
    void setup() {
		fakejetClientMock = Mockito.mock(FakejetClient.class);
		
		fakejetServiceImpl = new FakejetServiceImpl(fakejetClientMock);
	}
	
	@Test
	public void findOneWayFlights_test() {
		Mockito.when(fakejetClientMock.getAllFlights(USER, PASS, "LGW", "ALC", "2021-08-01"))
				.thenReturn(FakeJetSetUpUtil.getFakeJetResponse("LGW", "ALC", "2021-08-01"));
		
		OneWayFakeJetResponse fakeJetResponse = fakejetServiceImpl.findOneWayFlights("LGW", "ALC", "2021-08-01");
		assertFalse(fakeJetResponse.getFlights().isEmpty());
		assertEquals("LGW", fakeJetResponse.getFlights().get(0).getDepartureAirportIataCode());
	}
	
	@Test
	public void findReturnFlights_test() {
		Mockito.when(fakejetClientMock.getAllFlights(USER, PASS, "LGW", "ALC", "2021-08-01"))
				.thenReturn(FakeJetSetUpUtil.getFakeJetResponse("LGW", "ALC", "2021-08-01"));

		Mockito.when(fakejetClientMock.getAllFlights(USER, PASS, "ALC", "LGW", "2021-08-08"))
				.thenReturn(FakeJetSetUpUtil.getFakeJetResponse("ALC", "LGW", "2021-08-08"));

		ReturnFakeJetResponse fakeJetReturnResponse = fakejetServiceImpl.findReturnFlights("LGW", "ALC", "2021-08-01", 7);
		assertFalse(fakeJetReturnResponse.getFlights().isEmpty());
		assertEquals("ALC", fakeJetReturnResponse.getFlights().get(0).getReturnDepartureAirport());
	}
	
}
