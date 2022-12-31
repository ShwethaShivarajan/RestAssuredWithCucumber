package stepDefinitions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUDStepDefs {

	Response response;
	RequestSpecification request;
	Map<String, Object> mapObj = new HashMap<String, Object>();

	@Given("The base URI is {string}")
	public void the_base_URI_is(String URI) {
		// Write code here that turns the phrase above into concrete actions
		request = RestAssured.given().baseUri(URI);
	}

	@When("I perform the Get Operation")
	public void i_perform_the_Get_Operation() {
		// Write code here that turns the phrase above into concrete actions
		response = request.get();
	}

	@Then("Response code should be {int}")
	public void response_code_should_be(int expResponseCode) {

		Assert.assertEquals(expResponseCode, response.getStatusCode());
	}


	@When("I send {string} and {int}")
	public void i_send_and(String name, int salary) {
		// Write code here that turns the phrase above into concrete actions

		mapObj.put("name", name);
		mapObj.put("salary", salary);
	}

	@When("I perform post operation")
	public void i_perform_post_operation() {
		// Write code here that turns the phrase above into concrete actions
		response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(mapObj).post("/create");
		System.out.println(response.getBody().asString());
	}
}
