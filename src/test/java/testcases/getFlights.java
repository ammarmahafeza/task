package testcases;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import apitest.endpoints.searchPost;
import apitest.endpoints.flightApi;
import groovyjarjarpicocli.CommandLine.Parameters;
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
	int Adults ;
	String airPort ;
    String Departure = DepartureDate.format(DepartureDateFormat);
	String Return =ReturnDate.format(DepartureDateFormat);
	

@Test
//@Parameters({"AHB","JED"})
public  void getValidFlight(String originId ,String destinationId)

{      

	Response response =flightApi.getFlight(originId,destinationId,Departure,Return,2);
response.then().log().all();

Assert.assertEquals(response.getStatusCode(), 200);
String DepartureResponse = response.path("leg[0].departure"); 
assertEquals(DepartureResponse, Departure);

String ReturnResponse = response.path("request.leg[1].checkOut");
assertEquals(ReturnResponse, Return);


String destinationIdResponse = response.path("request.leg[0].destinationId") ;
assertEquals(destinationIdResponse, destinationId);

String originIdResponse = response.path("request.leg[0].originId");
assertEquals(originIdResponse, originId);
}
@Test
public  void getInvalidDesetnationFlights(String originId)

{      
Response response =flightApi.getFlight("AHB","AHB",Departure,Return,2);
response.then().log().all();
Assert.assertEquals(response.getStatusCode(), 400);
}

@Test
public  void getInvaliddatesFlights()

{      
Response response =flightApi.getFlight("AHB","JED",Departure,Departure,1);
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