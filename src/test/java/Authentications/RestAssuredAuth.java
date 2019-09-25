package Authentications;

import org.testng.annotations.Test;

import io.restassured.RestAssured;



public class RestAssuredAuth {
	
	@Test
	public void TestAuthentications()
	{
		int code = RestAssured.given()
				.auth().preemptive()
				.basic("ToolsQA","TestPassword")
				.when()
				.get("http://restapi.demoqa.com/authentication/CheckForAuthentication")
				.getStatusCode();
		
		System.out.println("Status Code is : " + code);
	}

}
