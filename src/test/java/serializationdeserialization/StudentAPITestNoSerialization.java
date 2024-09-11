package serializationdeserialization;

import java.util.ArrayList;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class StudentAPITestNoSerialization {
	
	public HashMap map=new HashMap();
	@Test(priority=1)
	public void createNewstudent()
	{
		map.put("id", 101);
		map.put("firstname", "suneel");
		map.put("lastname", "kumar");
		map.put("email", "abc@gmail.com");
		map.put("programname", "manager");
		
		ArrayList<String> courselist= new ArrayList<String>();
		courselist.add("Java");
		courselist.add("Selenium");
		
		map.put("Courses", courselist);
		
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post("http://localhost:8085/student")
		.then()
			.statusCode(200)
			.assertThat()
			.body("msg", equalTo("Student Added"));
		
		
		
	}
	//Get Request
	@Test(priority=2)
	void getStudentRecord()
	{
		given()
		.when().get("http://localhost:8085/student/101")
		.then()
			.statusCode(200)
			.assertThat()
			.body("id",equalTo(101));
	}
	
	
	

}
