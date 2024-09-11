package restassuredTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import java.util.HashMap;

import org.testng.annotations.Test;

public class Demo3_PUT_Request {
	
	public static HashMap map=new HashMap();
	
	String empname=RestUtils.getEmpName();
	String empsal=RestUtils.getEmpSal();
	String empage=RestUtils.getEmpage();
	int empid=11501;
		
	
	@BeforeClass
	public void putData()
	{
		map.put("Emp Name", empname);
		map.put("Emp sal", empsal);
		map.put("Emp age", empage);
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+empid;
		
	}
	
	@Test
	public void testput()
	{
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put()
		
		.then()
			.statusCode(200)
			.log().all();//giving complete api details
			
	}

}
