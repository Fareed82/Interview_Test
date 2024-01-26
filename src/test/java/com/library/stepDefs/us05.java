package com.library.stepDefs;

import com.github.javafaker.Faker;
import com.library.pages.AdminPanelPage;
import com.library.pages.BasePage;
import com.library.pages.BrandingPage;
import com.library.utility.BrowserUtil;
import com.library.utility.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class us05 extends BasePage {

    AdminPanelPage adminPanelPage = new AdminPanelPage();
    BrandingPage brandingPage = new BrandingPage();
    Faker faker = new Faker();
    String contactName;

    @When("I am logged in as an admin and go to {string} module")
    public void i_am_logged_in_as_an_admin_and_go_to_module(String moduleName) {
        adminPanelButton.click();

        adminPanelPage.login();

        adminPanelPage.navigateModule(moduleName);

    }


    @Then("I click and change the information for all of the details")
    public void i_click_and_change_the_information_for_all_of_the_details() {

        brandingPage.clear(brandingPage.nameBox);
        brandingPage.nameBox.sendKeys(faker.name().title());

        brandingPage.logoBox.clear();
        brandingPage.logoBox.sendKeys(ConfigurationReader.getProperty("uiLogo"));

        brandingPage.descriptionBox.clear();
        brandingPage.descriptionBox.sendKeys(faker.lorem().paragraph(4));

        brandingPage.latitudeBox.clear();
        brandingPage.latitudeBox.sendKeys(ConfigurationReader.getProperty("latitude"));

        brandingPage.longitudeBox.clear();
        brandingPage.longitudeBox.sendKeys(ConfigurationReader.getProperty("longitude"));

        //contactName = brandingPage.contactNameBox.getAttribute("value");

        brandingPage.contactNameBox.clear();
        brandingPage.contactNameBox.sendKeys(faker.name().fullName());

        brandingPage.contactAddressBox.clear();
        brandingPage.contactAddressBox.sendKeys(faker.address().fullAddress());

        brandingPage.contactPhoneBox.clear();
        brandingPage.contactPhoneBox.sendKeys(faker.numerify("############"));

        brandingPage.contactEmailBox.clear();
        brandingPage.contactEmailBox.sendKeys(faker.internet().emailAddress());

        brandingPage.updateBrandingButton.click();

    }

    @Then("validate the information has been updated")
    public void validate_the_information_has_been_updated() {
        Assert.assertTrue(brandingPage.updateSuccessfulMessage.isDisplayed());

        brandingPage.closeButton.click();

        //maybe but it does not equal
       // Assert.assertNotEquals(originalFirstName, NewnameHERE);

        Assert.assertEquals(ConfigurationReader.getProperty("uiLogo"), brandingPage.logoBox.getAttribute("value"));
        Assert.assertEquals(ConfigurationReader.getProperty("latitude"), brandingPage.latitudeBox.getAttribute("value"));
        Assert.assertEquals(ConfigurationReader.getProperty("longitude"), brandingPage.longitudeBox.getAttribute("value"));
    }

    @Then("I return to homepage and validate information has been update on UI")
    public void i_return_to_homepage_and_validate_information_has_been_update_on_ui() {
        adminPanelPage.navigateModule("Front Page");

        // maybe validate URL
        Assert.assertEquals(ConfigurationReader.getProperty("uiLogo") , hotelLogoUrl.getAttribute("src"));


    }


}
