package RestAussuredLearning;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.cliftonlabs.json_simple.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimplePostTest {

	@Test
	public void GetEmployeeDetails()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		RequestSpecification httpRequest = RestAssured.given();

		// We can add Key - Value pairs using the put method
		JsonObject requestParams = new JsonObject();
		requestParams.put("name", "test"); 
		requestParams.put("salary", "123");
		requestParams.put("age", "23");
		
		httpRequest.header("Content-Type", "application/json");
		 
		// Add the Json to the body of the request
		httpRequest.body(requestParams.toJson());
		 
		// Post the request and check the response
		Response response = httpRequest.post("/create");
		
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 200);
	}

}
