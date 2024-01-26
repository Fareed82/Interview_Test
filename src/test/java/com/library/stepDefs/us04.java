package com.library.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class us04 {

    Response response;

    RequestSpecification requestSpecification;
    String expectedFirstName;
    String expectedLastName;

    @Given("I create a random booking as request body")
    public void i_create_a_random_booking_as_request_body() {
        Map<String, Object> bookingDetails = new HashMap<>();
        expectedFirstName = "Test";
        expectedLastName = "User";
        bookingDetails.put("firstname", expectedFirstName);
        bookingDetails.put("lastname", expectedLastName);
        bookingDetails.put("totalprice", "500");
        bookingDetails.put("depositpaid", true);

        Map<String, Object> bookingDates = new LinkedHashMap<String, Object>();
        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2019-01-01");

        bookingDetails.put("bookingdates", bookingDates);

        bookingDetails.put("additionalneeds", "Lunch");


        System.out.println(RestAssured.baseURI);

        requestSpecification = RestAssured.given().contentType(ContentType.JSON)


                .body(bookingDetails);

    }

    @When("I send POST request to {string} endpoint")
    public void i_send_post_request_to_endpoint(String endpoint) {
        response = requestSpecification.when().post(endpoint);
    }

    @Then("verify the new user has booking has been created")
    public void verify_the_new_user_has_booking_has_been_created() {
        JsonPath jsonPath = response.jsonPath();
        String actualFirstName = jsonPath.getString("booking.firstname");
        String actualLastName = jsonPath.getString("booking.lastname");
        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
    }

    @Then("status code should be 200 for new booking")
    public void status_code_should_be() {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("Response Content type is {string} for new booking")
    public void response_content_type_is(String expectedContentType) {
        Assert.assertEquals(response.getContentType(), expectedContentType);
    }

}
