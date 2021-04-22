package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

public class Check_Status {
	
	//Check the status of the API
	@Test
	public void check_api_status () {
		
		baseURI = "https://gorest.co.in/public-api/";
		//GET
		given().
			get("posts").
				then().statusCode(200);
	}

}
