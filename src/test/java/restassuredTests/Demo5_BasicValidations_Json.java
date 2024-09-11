package restassuredTests;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Demo5_BasicValidations_Json {
	
	@Test(priority=1)
	public void teststatuscodes()
	{
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
			.statusCode(200);
			//.log().all();
			
			
	}
	
	@Test(priority=2)
	public void testlog()
	{
		given()
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority=3)
	public void testsinglecontent()
	{
		given()
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		
		.then()
			.statusCode(200)
			.body("RestResponse.result.name",equalTo("India"));
	}
	
	@Test(priority=4)
	public void testmultiplecontents()
	{
		given()
		.when()
			.get("http://services.groupkt.com/country/get/all")
		
		.then()
			.statusCode(200)
			.body("RestResponse.result.name",hasItems("India","Australia","United states of america"));
	}
	
	@Test(priority=5)
	public void testparamsandheaders()
	{
		given()
			.param("MyName", "suneel")
			.header("Myheader","suneel")
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	

}
