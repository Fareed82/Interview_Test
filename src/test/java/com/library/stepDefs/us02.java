package com.library.stepDefs;

import com.github.javafaker.Faker;
import com.library.pages.BasePage;
import com.library.utility.BrowserUtil;
import com.library.utility.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class us02 extends BasePage {

    Faker faker = new Faker();

    @Given("I am on the hotel homepage")
    public void i_am_on_the_hotel_homepage() {
        //connection will be made from @before("@ui") setup method in hooks class
    }

    @Given("I scroll down to the contact form")
    public void i_scroll_down_to_the_contact_form() {
        BrowserUtil.scrollToElement(contactNameBox);
    }

    @Then("I click on Submit without completing the form and validate error\\(s)")
    public void i_click_on_submit_without_completing_the_form_and_validate_error_s() {
        contactNameBox.sendKeys(faker.lordOfTheRings().character());
        contactEmailBox.sendKeys(faker.internet().emailAddress());
        contactPhoneBox.sendKeys(faker.numerify("############"));
        contactSubjectBox.sendKeys(faker.superhero().power());

        contactFormSubmitButton.click();

        Assert.assertTrue(contactMessageBoxError_1.isDisplayed());
        Assert.assertTrue(contactMessageBoxError_2.isDisplayed());


    }

    @Then("I complete the form and validate success message")
    public void i_complete_the_form_and_validate_success_message() {
        contactMessageBox.sendKeys(faker.hobbit().quote());

        contactFormSubmitButton.click();

        Assert.assertTrue(contactSuccessMessage.isDisplayed());

    }


}
