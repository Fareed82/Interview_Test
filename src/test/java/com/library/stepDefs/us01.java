package com.library.stepDefs;

import com.github.javafaker.Faker;
import com.library.pages.BasePage;
import com.library.pages.AdminPanelPage;
import com.library.utility.ConfigurationReader;
import com.library.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class us01 extends BasePage {

    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();
    AdminPanelPage adminPanelPage = new AdminPanelPage();


    @Then("I scroll down to the bottom of the page and click on Admin panel and Login")
    public void i_scroll_down_to_the_bottom_of_the_page_and_click_on_admin_panel_and_login() {
        adminPanelButton.click();

        adminPanelPage.usernameBox.sendKeys(ConfigurationReader.getProperty("loginUsername"));
        adminPanelPage.passwordBox.sendKeys(ConfigurationReader.getProperty("loginPassword"));

        adminPanelPage.loginButton.click();

    }

    @When("I click on the first available room reservation")
    public void i_click_on_the_first_available_room_reservation() {
        adminPanelPage.firstRowBooking.click();

    }

    @Then("I click edit icon on the first booking")
    public void i_click_edit_icon_on_the_first_booking() {
        adminPanelPage.editButton.click();
    }

    @Then("I change the first name, last name, deposit paid status, check in date, and check out date")
    public void i_change_the_first_name_last_name_deposit_paid_status_check_in_date_and_check_out_date() {

        adminPanelPage.checkInCalendar.click();
        actions.moveToElement(adminPanelPage.checkInCalendarBox);
        adminPanelPage.newCheckInDate.click();

        adminPanelPage.checkOutCalendar.click();
        actions.moveToElement(adminPanelPage.checkInCalendarBox);
        adminPanelPage.newCheckOutDate.click();

        adminPanelPage.firstName.clear();
        adminPanelPage.firstName.sendKeys("Tester");

        adminPanelPage.lastName.clear();
        adminPanelPage.lastName.sendKeys("User");

        Select select = new Select(adminPanelPage.depositPaidDropdown);
        select.selectByValue("false");

    }

    @Then("I click update and validate my booking information has been updated")
    public void i_click_update_and_validate_my_booking_information_has_been_updated() {

        adminPanelPage.confirmBookingButton.click();

        Assert.assertEquals("Tester", adminPanelPage.updatedFirstName.getText());
        Assert.assertEquals("User", adminPanelPage.updatedLastName.getText());
        Assert.assertEquals("false", adminPanelPage.updatedDepositStatus.getText());
        Assert.assertEquals("2022-01-25", adminPanelPage.updatedCheckInDate.getText());
        Assert.assertEquals("2022-01-30", adminPanelPage.updatedCheckOutDate.getText());





    }


}
