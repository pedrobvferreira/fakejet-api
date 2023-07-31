# fakejet-api:
Flight availability
---------------------------------------------------------------------------------------------
## Oneway flights:
Make a single request to the FakeJet API to retrieve flight availability for the user-defined route & date parameters.

`GET` request to `/search/oneway-flights?departureAirport=LGW&arrivalAirport=ALC&departureDate=2021-08-01`:
* the response code is 404 if Not Found.
* the response code is 200 if Sucess, and the response body is an array of matching flights, with:
   - Departure airport
   - Arrival airport
   - Departure date & time
   - Flight number
   - Available Seats
   - Cost

## Return flights:
Make two requests to the FakeJet API to retrieve flight availability for the user-defined route, date & holiday duration. 
The holiday duration is defined as the number of days the user wishes to spend on holiday before returning home.

`GET` request to `/search/return-flights?departureAirport=LGW&arrivalAirport=ALC&departureDate=2021-08-01&holidayDuration=7`:
* the response code is 404 if Not Found.
* the response code is 200 if Sucess, and the response body is an array of matching flights, with:
   - Departure airport
   - Arrival airport
   - Departure date & time
   - Flight number
   - Available Seats
   - Cost
   - Return Departure airport
   - Return Arrival airport
   - Return Departure date & time
   - Return Flight number
   - Return Available Seats
   - Return Cost

----------------------
## Solution:
* Time spent on the test:
   - 2 days
* Improves to the FakeJet API: 
   - change the requests to use maybe an WebClient
* Design decisions you have made:
   - create packages for different parts of the flighs-api (response, controller, service, client).
* How we can build & run the code:
   - Run the endpoints oneway-flights, and return-flights
* Any assumptions that you have made because you were unsure of any of the requirements:
   - I assumed that in point 2 it was supposed to have two endpoints with x days of difference, where the first would bring the list of outward flights and the second would bring a list with the return flights.


----------------------
## Testing in Spring Boot:
* FakejetServiceImplTest for Service
