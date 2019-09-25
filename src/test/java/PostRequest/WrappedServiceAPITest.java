package PostRequest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured;

public class WrappedServiceAPITest {



	  @BeforeClass
	  public void setBaseUri () {

	   // RestAssured.baseURI = "http://192.168.112.44:8066/WrapperService/ISHRAQOnlineBankingIntegrationService.asmx";

	  }

	
	@Test
	public void readCustomerData() {
		
		 Response res =   RestAssured.given().param ("customerCIFNumber", "188")
				  				.when()
				  				.get("http://192.168.112.44:8066/WrapperService/ISHRAQOnlineBankingIntegrationService.asmx")
				  				.then()
				  				.extract().response();
		  
		  System.out.println (res.asString());
		  System.out.println("Status Code is : " + res.statusCode());
		  System.out.println("Status Code is : " + res.getHeaders());
	}
}
