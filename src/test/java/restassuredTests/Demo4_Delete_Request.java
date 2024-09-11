package restassuredTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Demo4_Delete_Request {
	
	@Test
	public void deleteEmployeeRecord()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/11500";
		
		Response response =
		given()
					
		.when()
			.delete()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all()
			.extract().response();
		
		String jsonstring=response.asString();
		Assert.assertEquals(jsonstring.contains("Successfully! Record has been deleted"),true);
		
	}

}
