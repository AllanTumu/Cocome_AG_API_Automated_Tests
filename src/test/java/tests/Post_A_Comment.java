package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Post_A_Comment {
	
	@Test
	public void post_comment() {
		
		JSONObject request = new JSONObject();
		request.put("id",8);
		request.put("post_id", 10);
		request.put("name", "Allan Tumuhimbise");
		request.put("email", "allan6@cocomoreag.io");
		request.put("body", "Check the Essentials of the system");
		
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://gorest.co.in/public-api/";
		given().
			auth().oauth2("a92b4e8642b28635193377724bbf485556f6456ac30a3336b5bd7ef4fc9e869b").
			header("Accept", "application/json").
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
			
		when().
			post("/comments").
		then().
			statusCode(200).
			log().all().
			body("data.body", equalTo("Check the Essentials of the system")).
			body("data.name", equalTo("Allan Tumuhimbise"));
	}

}
