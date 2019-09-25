package GetRequest;



import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetData {
	
	String endPoint = "http://192.168.112.44:8066/WrapperService/ISHRAQOnlineBankingIntegrationService.asmx";
	
	@Test
	public void testResponseCode () {

	Response response =	get(endPoint);
	
	int code = response.getStatusCode();
	
	System.out.println("Status code is : " + code);
	
	Assert.assertEquals(code, 200);
	}
	
	@Test
	public void testResponseBody() {
		String responseData = get("endPoint").asString();
		long responseTime = get("endPoint").getTime();
		System.out.println("Response body in Json is : " + responseData);
		System.out.println("Response Time is : " + responseTime);
	}

}
