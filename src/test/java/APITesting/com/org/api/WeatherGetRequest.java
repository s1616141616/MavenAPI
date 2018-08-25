package APITesting.com.org.api;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

public class WeatherGetRequest {

	// Simple get request for getting weather request by city name

	@Test
	public void Test_01() {
		
		Response resp = when().
						get("https://samples.openweathermap.org/data/2.5/weather?q=London&appid=b6907d289e10d714a6e88b30761fae22");

		System.out.println(resp.getStatusCode());
		assertTrue(true);
	}

	@Test
	public void Test_02() {

		Response resp = when().
				get("https://samples.openweathermap.org/data/2.5/weather?q=London&appid=b6907d289e10d714a6e88b30761fae22");

		System.out.println(resp.getStatusCode());
		System.out.println("Because of priority Test_02 executed first");
		Assert.assertEquals(resp.getStatusCode(), 200);

	}

	// use parameter
	@Test
	public void Test_03() {

		Response resp = given().
						param("q", "London").
						param("appid", "089e27e805692abf8c050f333c49d4fe").
						when().
						get("https://samples.openweathermap.org/data/2.5/weather");

		if (resp.getStatusCode() == 200) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

	@Test
	public void Test_04() {

						given().
						param("q", "London").
						param("appid", "089e27e805692abf8c050f333c49d4fe").
						when().
						get("https://samples.openweathermap.org/data/2.5/weather").
						then().
						assertThat().statusCode(200);

	}

	@Test
	public void Test_05() {

		Response resp = given().
						param("q", "London").
						param("appid", "089e27e805692abf8c050f333c49d4fe").
						when().
						get("https://samples.openweathermap.org/data/2.5/weather");

		System.out.println(resp.asString());
		System.out.println(".......................");
	}

	@Test
	public void Test_06() {

		Response resp = given().
						param("id", "2172797").
						param("appid", "089e27e805692abf8c050f333c49d4fe").
						when().
						get("https://samples.openweathermap.org/data/2.5/weather");

		Assert.assertEquals(resp.getStatusCode(), 200);

		System.out.println(resp.asString());
	}

	@Test
	public void Test_07() {

		Response resp = given().
						param("zip", "1214,BGD").
						param("appid", "089e27e805692abf8c050f333c49d4fe").
						when().
						get("https://samples.openweathermap.org/data/2.5/weather");

		Assert.assertEquals(resp.getStatusCode(), 200);

		System.out.println(resp.asString());
	}
	
	@Test
	public void Test_08() {
		
		String weatherReport = given().
						param("id", "2172797").
						param("appid", "089e27e805692abf8c050f333c49d4fe").
						when().
						get("https://samples.openweathermap.org/data/2.5/weather").
						then().
						contentType(ContentType.JSON).
						extract().
						path("weather[0].description");
		
		System.out.println(weatherReport);
	}
	
	@Test
	public void Test_09() {
		
		Response resp = given().
						param("id", "2172797").
						param("appid", "089e27e805692abf8c050f333c49d4fe").
						when().
						get("https://samples.openweathermap.org/data/2.5/weather");
						
		String actualReport = resp.
							  then().
							  contentType(ContentType.JSON).
							  extract().
							  path("weather[0].description");
		
		String expectedReport =null;
		
					if (actualReport.equalsIgnoreCase(expectedReport)) {
						System.out.println("Test Successful");
					}	else {
						System.out.println("Test failed.");
					}
		}
	
	@Test
	public void Test_10() {
		
		Response resp = given().
						param("id","2172797").
						param("appid", "089e27e805692abf8c050f333c49d4fe").
						when().
						get("https://samples.openweathermap.org/data/2.5/weather");

		String responseID = resp.
							then().
							contentType(ContentType.JSON).
							extract().
							path("weather[0].description");
		
		System.out.println("ResponseID issssssssssssss " +responseID);
		
		
		String lon =	String.valueOf(resp.
						then().
						contentType(ContentType.JSON).
						extract().
						path("coord.lon"));
		
		System.out.println("Longtitude is "+ lon);
		
		
		String lat =	String.valueOf(resp.
						then ().
						contentType(ContentType.JSON).
						extract().
						path("coord.lat"));
				
		System.out.println("Lattitude is "+ lat);
					}

}