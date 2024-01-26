package com.library.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.Optional;

public class us03 {

    Response apiResponse;
    RequestSpecification specification;

    @Given("I am connected to API")
    public void i_am_connected_to_api() {
       //set up with be from hooks class
         specification = RestAssured.given().contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }

    @When("I send GET request to {string} endpoint")
    public void i_send_get_request_to_endpoint(String endpoint) {
       apiResponse = specification.header("Accept" , "application/json")
                .when().get(endpoint);
    }

    @Then("status code should be 200")
    public void status_code_should_be() {
        Assert.assertEquals(apiResponse.getStatusCode() , 200);
    }

    @Then("Response Content type is {string}")
    public void response_content_type_is(String expectedContentType) {
        Assert.assertEquals(apiResponse.getContentType() , expectedContentType);
    }

    @Then("{string} should not be null")
    public void should_not_be_null(String example1) {
        Assert.assertNotNull(apiResponse.jsonPath().get("bookingid"));
    }



}
