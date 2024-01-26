package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.library.utility.Driver.*;

public class BrandingPage {

    public BrandingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "name")
    public WebElement nameBox;

    @FindBy(id = "logoUrl")
    public WebElement logoBox;

    @FindBy(id = "description")
    public WebElement descriptionBox;

    @FindBy(id = "latitude")
    public WebElement latitudeBox;

    @FindBy(id = "longitude")
    public WebElement longitudeBox;

    @FindBy(id = "contactName")
    public WebElement contactNameBox;

    @FindBy(id = "contactAddress")
    public WebElement contactAddressBox;

    @FindBy(id = "contactPhone")
    public WebElement contactPhoneBox;

    @FindBy(id = "contactEmail")
    public WebElement contactEmailBox;

    @FindBy(id = "updateBranding")
    public WebElement updateBrandingButton;

    public void clear(WebElement element){
        element.clear();
    }

    @FindBy(xpath = "//button[normalize-space()='Close']")
    public WebElement closeButton;

    @FindBy(xpath = "//p[normalize-space()='Branding updated!']")
    public WebElement updateSuccessfulMessage;


}
