package StepsDefinition;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class AssertResponse {

	Response response;
	@Test
	@Given("api for foreign exchange")
	public void api_for_foreign_exchange() {
	    RestAssured.baseURI="https://api.ratesapi.io";
	}
	
	@Test
	@When("passed valid values from get method")
	public void passed_valid_values_from_get_method() {
	   RequestSpecification httpRequest=RestAssured.given();
	   response=httpRequest.request(Method.GET,"/api/latest?base=USD");
	}

	@Test
	@Then("validate the response received from the response body")
	public void validate_the_response_received_from_the_response_body() {
	   int StatusCode=response.getStatusCode();
	   Assert.assertEquals(200,StatusCode);

	   String head=response.getHeader("Content-Type");
	   Assert.assertTrue(head.contains("application/json"));
	   response.prettyPrint();
	}

	
}
