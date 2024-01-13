package apitest.endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import payload.searchData;
import io.restassured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class flightApi {
	
	


	public static  Response getFlight(String destinationId,String originId, String chekin, String checkOut,int adults)
	{		

		 Response response = (Response) given().pathParams("destinationId", destinationId,"originId",originId,"fromdate",chekin,"todate",checkOut,"adultscount",adults)
	                .contentType("ContentType.JSON")
	       		 .when()
	     		.get(Routes.flightApiURL)
	     		
		 .then()
         .assertThat()
         .body(matchesJsonSchemaInClasspath("getFlight.json"));
		;
		 return response; 
	}


}
	