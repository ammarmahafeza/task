package testcases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import apitest.endpoints.searchPost;
import io.restassured.response.Response;
import payload.searchData;

public class postSearchHotels {
    Random randomDays = new Random();
    LocalDate currentDate = LocalDate.now();
    // Generate a random number of days to add to the current date
    Random random = new Random();
    // Calculate the new date by adding random days to the current date
    LocalDate checkInInDate = currentDate.plusDays(3);
    // Format the LocalDate as a string
    DateTimeFormatter checkInInDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");    
    LocalDate checkOutDate= checkInInDate.plusDays(3);
	int Adults ;
	String airPort ;
    String checkIn = checkInInDate.format(checkInInDateFormat);
	String checkOut =checkOutDate.format(checkInInDateFormat);

	searchData payload ;
	@BeforeMethod
	public void setData()
	{
	
	    payload =new searchData();
	    payload.setCheckIn(checkIn);
		payload.setCheckOut(checkOut);
		payload.setPlaceID("ChIJRcbZaklDXz4RYlEphFBu5r0");
	

	}
	
	
@Test
	public  void validateidentifier()
{
	try {
		
		
		Response response =searchPost.validateidentifier(payload);
	    response.then().log().all()
	    .extract().response();
	     Assert.assertEquals(response.getStatusCode(), 200);
	    String ID = response.path("sId");
	assert (ID != null) : "ID is null";
}
	
catch (Exception ex) {
	ex.printStackTrace();
}

}

//


@Test
public  void invalidCase_CheckOutbeforIn()

{
    payload.setCheckIn(checkOut);
    payload.setCheckOut(checkIn);
//
   //
   Response response =searchPost.validateidentifier(payload);
   response.then().log().all();
    Assert.assertEquals(response.getStatusCode(), 400);

}

@Test	
public  void nullDates()
	
	{
	payload.setCheckIn("");
    payload.setCheckOut("");

     Response response =searchPost.validateidentifier(payload);
     response.then().log().all();
     response.then().assertThat().statusCode(200);
}

}


