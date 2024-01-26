package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * parent class for concrete Page object classes
 * provides constructor with initElements method for re-usability
 * abstract - to prevent instantiation.
 */
public abstract  class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='name']")
    public WebElement contactNameBox;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement contactEmailBox;

    @FindBy(xpath = "//input[@id='phone']")
    public WebElement contactPhoneBox;

    @FindBy(xpath = "//input[@id='subject']")
    public WebElement contactSubjectBox;

    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement contactMessageBox;

    @FindBy(xpath = "//button[@id='submitContact']")
    public WebElement contactFormSubmitButton;

    @FindBy(xpath = "//p[normalize-space()='Message must be between 20 and 2000 characters.']")
    public WebElement contactMessageBoxError_1;

    @FindBy(xpath = "//p[normalize-space()='Message may not be blank']")
    public WebElement contactMessageBoxError_2;

    @FindBy(xpath = "//h2[contains(normalize-space(), 'Thanks for getting in')]")
    public WebElement contactSuccessMessage;

    @FindBy(xpath = "//button[normalize-space()='Book this room']")
    public WebElement bookThisRoomButton;

    @FindBy(xpath = "//input[@placeholder='Firstname']")
    public WebElement firstNameInputBox;

    @FindBy(xpath = "//input[@placeholder='Lastname']")
    public WebElement lastNameInputBox;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phoneInputBox;

    @FindBy(xpath = "//button[normalize-space()='Book']")
    public WebElement bookRoomButton;

    @FindBy(xpath = "//body/div[@id='root']/div/div[@class='container-fluid']/div/div/div[@class='row hotel-room-info']/div[@class='col-sm-6']/div[@class='rbc-calendar']/div[@aria-label='Month View']/div[5]/div[2]/div[2]/div[1]")
    public WebElement checkInDate;

    @FindBy(xpath = "//div[@class='rbc-day-bg rbc-selected-cell']")
    public WebElement checkOutDate;

    @FindBy(xpath = "//p[normalize-space()='must not be empty']")
    public WebElement bookingPhoneErrorMessage;

    @FindBy(xpath = "//h3[normalize-space()='Booking Successful!']")
    public WebElement bookingSuccessfulMessage;

    @FindBy(xpath = "//button[@class='btn btn-outline-primary']")
    public WebElement bookingSuccessfulCloseButton;

    @FindBy(xpath = "//a[normalize-space()='Admin panel']")
    public WebElement adminPanelButton;

    @FindBy(xpath = "//img[@alt='Hotel logoUrl']")
    public WebElement hotelLogoUrl;






}
