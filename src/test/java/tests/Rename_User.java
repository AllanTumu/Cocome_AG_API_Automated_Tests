package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

/**
 * Rename the user and check it was correctly updated in the system.
 * @author Allan
 *
 */

public class Rename_User {
	
	@Test
	public void rename_user() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Allan Tumuhimbise");
		request.put("email", "allan7@cocomoreag.io");
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
			patch("users/24").
		then().
			assertThat().
			statusCode(200).
			log().all().
			body("data.email", Matchers.is("allan7@cocomoreag.io"));
	}

}
