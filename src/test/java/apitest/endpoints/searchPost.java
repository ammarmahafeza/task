package apitest.endpoints;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.sql.Date;
import java.time.LocalDate;

import payload.searchData;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


public class searchPost {
	

	
	public static  Response validateidentifier(searchData payload)
	{	
			
			 Response response =(Response) given()
		             .contentType("application/json")
		             .header("token","skdjfh73273$7268u2j89s" )
		             .body(payload).log().all()
			 .when()
			.post(Routes.searchPost);
			 return response; 
		

		 
		 
	
	}
}