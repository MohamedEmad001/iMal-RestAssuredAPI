package PostRequest;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostData {
	
	String endPoint = "http://192.168.112.44:8066/WrapperService/ISHRAQOnlineBankingIntegrationService.asmx";
	
	@SuppressWarnings("unchecked")
	@Test
	public void PostDataRequest() {
		
	RequestSpecification request = RestAssured.given();
	JSONObject jobj = new JSONObject();
	
	jobj.put("id", "13");
	jobj.put("name", "Emad");
	jobj.put("job", "Senior QC");
	
	request.body(jobj.toJSONString());
	
	Response response = request.post(endPoint);
	int code = response.getStatusCode();
	
	System.out.println("Status Code is : " + code);
	

		
	}

}
