package restassuredTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Demo6_Basicvalidations_XMLformat {
	
@Test(priority=1)	
void testsinglecontent()
{
	given()
	.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
	.then()
		.body("CUSTOMER.ID", equalTo("15"))
		.log().all();
	
}

@Test(priority=2)	
void testmultiplecontent()
{
	given()
	.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
	.then()
		.body("CUSTOMER.ID", equalTo("16"))
		.body("CUSTOMER.FIRTNAME", equalTo("suneel"))
		.body("CUSTOMER.LASTNAME", equalTo("ch"))
		.body("CUSTOMER.CITY", equalTo("Hyderabad"));
}

@Test(priority=3)	
void testmultiplecontentonego()
{
	given()
	.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
	.then()
		.body("CUSTOMER.text()", equalTo("16suneelchHyderabad"));
		
}

@Test(priority=4)	
void testusingxpath1()
{
	given()
	.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
	.then()
		.body(hasXPath("/CUSTOMER/FIRSTNAME"), containsString("suneel"));
		
}

@Test(priority=5)	
void testusingxpath2()
{
	given()
	.when()
		.get("http://thomas-bayer.com/sqlrest/INVOICE/")
	.then()
		.body(hasXPath("INVOICELIST/INVOICE[text()='30']"))
		.log().all();
		
}
	

}
