package testcases;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.String;
import apitest.endpoints.flightApi;
import io.restassured.response.Response;

public class getFlights {

    Random randomDays = new Random();
    LocalDate currentDate = LocalDate.now();
    // Generate a random number of days to add to the current date
    Random random = new Random();
    // Calculate the new date by adding random days to the current date
    LocalDate DepartureDate = currentDate.plusDays(3);
    // Format the LocalDate as a string
    DateTimeFormatter DepartureDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate ReturnDate = DepartureDate.plusDays(3);
	int Adults = 1 ;
	String airPort ;
    String Departure = DepartureDate.format(DepartureDateFormat);
	String Return =ReturnDate.format(DepartureDateFormat);
	String originId  = "RUH";
	String destinationId = "JED";
	

@Test
public  void getValidFlight()

{
	
	
	Response response =flightApi.getFlight(originId,destinationId,Departure,Return,2);
	Assert.assertEquals(response.getStatusCode(), 200);
	response.then().body(matchesJsonSchemaInClasspath("getFlight.json"));
	String DepartureResponse = response.path("request.leg[0].departure");
	assertEquals(DepartureResponse, Departure);
	
//	String originIdResponse = response.path("request.leg[0].originId");
//	assertEquals(originIdResponse, originId);
}
@Test
public  void getInvalidDesetnationFlights()

{
Response response =flightApi.getFlight("AHB","AHB",Departure,Return,2);
response.then().log().all();
Assert.assertEquals(response.getStatusCode(), 400);
}

@Test
public  void getInvaliddatesFlights()

{
Response response =flightApi.getFlight("JED","JED",Departure,Departure,1);
response.then().log().all();
Assert.assertEquals(response.getStatusCode(), 400);
}

@Test
public  void getNulldataFlights()

{
Response response =flightApi.getFlight("","","","",0);
response.then().log().all();
Assert.assertEquals(response.getStatusCode(), 400);
}
}