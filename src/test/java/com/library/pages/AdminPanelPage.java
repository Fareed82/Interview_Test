package com.library.pages;

import com.library.utility.ConfigurationReader;
import com.library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPanelPage {

    public AdminPanelPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "doLogin")
    public WebElement loginButton;

   @FindBy(id = "room1")
    public WebElement firstRowBooking;

    @FindBy(xpath = "//body//div[@id='root']//div[@class='container']//div//div//div//div[1]//div[1]//div[1]//div[7]//span[1]")
    public WebElement editButton;

    @FindBy(xpath = "//div[@aria-label='Choose Tuesday, January 25th, 2022']")
    public WebElement newCheckInDate;

    @FindBy(xpath = "//div[@aria-label='Choose Sunday, January 30th, 2022']")
    public WebElement newCheckOutDate;

    @FindBy(xpath = "(//input[@class='form-control'])[3]")
    public WebElement checkInCalendar;

    @FindBy(xpath = "(//input[@class='form-control'])[4]")
    public WebElement checkOutCalendar;

    @FindBy(xpath = "//div[@class='react-datepicker-popper']")
    public WebElement checkInCalendarBox;

    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstName;


    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastName;

    @FindBy(xpath = "//select[@name='depositpaid']")
    public WebElement depositPaidDropdown;

    @FindBy(xpath = "//span[@class='fa fa-check confirmBookingEdit']")
    public WebElement confirmBookingButton;

    @FindBy(xpath = "//p[text()='Tester']")
    public WebElement updatedFirstName;

    @FindBy(xpath = "//p[text()='User']")
    public WebElement updatedLastName;

    @FindBy(xpath = "//p[text()='false']")
    public WebElement updatedDepositStatus;

    @FindBy(xpath = "//p[text()='2022-01-25']")
    public WebElement updatedCheckInDate;

    @FindBy(xpath = "//p[text()='2022-01-30']")
    public WebElement updatedCheckOutDate;

    public void login() {
        usernameBox.sendKeys(ConfigurationReader.getProperty("loginUsername"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("loginPassword"));
        loginButton.click();
    }

    public void navigateModule(String moduleName){
        Driver.getDriver().findElement(By.xpath("//a[@class='nav-link'][.='"+moduleName+"']")).click();
    }





}
