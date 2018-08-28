package APITesting;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import APITesting.classes.Info;
import APITesting.classes.Posts;
import APITesting.classes._Posts;

import static com.jayway.restassured.RestAssured.*;

public class JSONServerRequest {

	// GET
	// @Test
	public void Test_01() {

		Response resp = given().
						when().
						get("http://localhost:3000/student");

		System.out.println(resp.asString());
	}
	// POST
	// @Test
	public void Test_02() {

		Response resp = given().
						body("	{\"id\":\"2\"," + " \"title\": \"sql-server\"," + "\"author\": \"Harun\"}").
						when().
						contentType(ContentType.JSON).
						post("http://localhost:3000/posts");

		System.out.println(resp.asString());

	}

//	@Test
	public void Test_03() {

		Response resp = given().
						body("	{\"id\" :\"3\", \"title\" : \"linux-server\", \"author\" : \"saiful\"}	").
						when().
						contentType(ContentType.JSON).
						post("http://localhost:3000/posts");

		System.out.println(resp.asString());

	}

	// @Test
	public void Test_04() {

		Posts posts = new Posts();

		posts.setId("4");
		posts.setTitle("islam-study");
		posts.setAuthor("Mawlan-Mohsin");

		Response resp = given().
						when().
						contentType(ContentType.JSON).
						body(posts).
						post("http://localhost:3000/posts");

		System.out.println(resp.asString());

	}

	// to GET data
	// @Test
	public void Test_05() {

		Response resp = given().
						when().
						get("http://localhost:3000/posts/4");

		System.out.println(resp.asString());

	}

	// PUT for update
	// @Test
	public void Test_06() {
		Posts posts = new Posts();

		posts.setId("4");
		posts.setTitle("Islam-History");
		posts.setAuthor("LRB");

		Response resp = given().
						when().
						contentType(ContentType.JSON).
						body(posts).
						put("http://localhost:3000/posts/4");

		System.out.println(resp.asString());

	}

	// PATCH for update
	// @Test
	public void Test_07() {

		Response resp = given().
						body("{\"title\" : \"Islmic-History\"}").
						when().
						contentType(ContentType.JSON).
						patch("http://localhost:3000/posts/4");

		System.out.println(resp.asString());

	}

	// DELETE
	// @Test
	public void Test_08() {

		Response resp = given().
						when().
						delete("http://localhost:3000/posts/4");

		System.out.println(resp.asString());

	}

	//@Test
	public void Complex_Post() {
		Info info = new Info();

		info.setEmail("info@hhh.com");
		info.setAddress("5346 LomaLInda");
		info.setCell("3235577295");

		_Posts posts = new _Posts();

		posts.setId("420");
		posts.setName("Babu");
		posts.setCountry("India");
		posts.setInfo(info);

		Response resp = given().
						when().
						contentType(ContentType.JSON).
						body(posts).
						post("http://localhost:3000/student");

		System.out.println(resp.asString());
	}

}