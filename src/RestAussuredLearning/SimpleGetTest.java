package RestAussuredLearning;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleGetTest {

	@Test
	public void GetEmployeeDetails()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "/employees");

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 200);
		System.out.println("Response Code is =>  " + statusCode);
		System.out.println("Response Body is =>  " + responseBody);

		String contentType = response.header("Content-Type");
		 System.out.println("Content-Type value: " + contentType);
		 
		 // Reader header of a give name. In this line we will get
		 // Header named Server
		 String serverType =  response.header("Server");
		 System.out.println("Server value: " + serverType);
		 
		 // Reader header of a give name. In this line we will get
		 // Header named Content-Encoding
		 String acceptLanguage = response.header("Content-Encoding");
		 System.out.println("Content-Encoding: " + acceptLanguage);
		 
		// Get the status line from the Response and store it in a variable called statusLine
		 String statusLine = response.getStatusLine();
		 assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
		 
		/*
		 * RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		 * RequestSpecification httpRequest1 = RestAssured.given(); Response response1 =
		 * httpRequest1.get("/employees/1");
		 * 
		 * JsonPath jsonPathEvaluator = response1.jsonPath();
		 * 
		 * // Then simply query the JsonPath object to get a String value of the node //
		 * specified by JsonPath: City (Note: You should not put $. in the Java code)
		 * String employeeName = jsonPathEvaluator.get("id");
		 * 
		 * // Let us print the city variable to see what we got
		 * System.out.println("Employee Name received from Response " + employeeName);
		 * 
		 * // Validate the response assertEquals(employeeName, "1",
		 * "Correct Employee Name received in the Response");
		 */
		 
	}

}
