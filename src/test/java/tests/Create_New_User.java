package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
Create a new user in the system. 
Make the corresponding assertions to confirm the data persists.
*/

public class Create_New_User {
	
	@Test
	public void create_user() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Allan Tumuhimbise");
		request.put("email", "allan5@cocomoreag.io");
		request.put("gender", "Male");
		request.put("status", "Active");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://gorest.co.in/public-api/";
		given().
			auth().oauth2("a92b4e8642b28635193377724bbf485556f6456ac30a3336b5bd7ef4fc9e869b").
			header("Accept", "application/json").
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
			
		when().
			post("/users").
		then().
			statusCode(200).
			log().all().
			body("data.name", equalTo("Allan Tumuhimbise"));
	}

}
