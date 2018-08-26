package APITesting.com.org.api;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

public class JSONServerRequest {

	// GET
	@Test
	public void Test_01() {
		
	Response resp = given().
					when().
					get("http://localhost:3000/posts");

	System.out.println(resp.asString());
	}

	//POST
	//@Test
	public void Test_02() {
		
		Response resp= given().
		body("	{\"id\":\"2\","
				+ " \"title\": \"sql-server\","
				+ "\"author\": \"Harun\"}").
		when().
		contentType(ContentType.JSON).
		post("http://localhost:3000/posts");
		
		System.out.println(resp.asString());
		
	}
}
