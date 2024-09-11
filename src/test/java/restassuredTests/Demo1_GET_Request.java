package restassuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;


public class Demo1_GET_Request {
	
	@Test
	public void getweatherDetails()
	{
		given()
		.when()
			.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1/1 200 OK")
		.assertThat().body("City", equalTo("Hyderabad"))
		.header("Content-Type","application/json");
	
		
	}

}
