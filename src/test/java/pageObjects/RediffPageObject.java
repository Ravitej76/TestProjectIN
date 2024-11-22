package pageObjects;

import Utilities.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffPageObject extends BaseTest {
    private final WebDriver driver;

    //Declaration
    @FindBy(xpath = "//td[.='Full Name']/..//input['text']")
    private WebElement fullnameField;

    @FindBy(xpath = "//td[.='Choose a Rediffmail ID']/..//input[@type='text']")
    private WebElement idfield;

    @FindBy(xpath = "//input[@value='Check availability']")
    private WebElement checkAvailabiltyButton;

    @FindBy(xpath = "//div[@id='check_availability']//b[1]")
    private WebElement checkAvailabilityMessage;

    @FindBy(xpath = "//input[@id='newpasswd']")
    private WebElement newpassword;

    @FindBy(xpath = "//input[@id='newpasswd1']")
    private WebElement reenterpassword;

    @FindBy(xpath = "//td[.='Alternate Email Address']/..//input[@type='text']")
    private WebElement alternateEmailfield;

    @FindBy(id = "mobno")
    private WebElement mobNo;

    @FindBy(xpath = "//select[contains(@name,'DOB_Day')]")
    private WebElement dayDropdown;

    @FindBy(xpath = "//select[contains(@name,'DOB_Month')]")
    private WebElement monthDropdown;

    @FindBy(xpath = "//select[contains(@name,'DOB_Year')]")
    private WebElement yearDropdown;

    @FindBy(xpath = "//input[@value='f']")
    private WebElement gender;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(xpath = "//select[contains(@name, 'city')]")
    private WebElement city;

    //Initilization
    public RediffPageObject() {
        this.driver = openBrowser();
        PageFactory.initElements(driver, this);

    }

    //Utilization
    public void enterFullname(String name) throws Exception {
        typeIntoElement(fullnameField, name, "Fullname");
    }

    public void idfield(String name) throws Exception {
        typeIntoElement(idfield, name, "idfield");
    }

    public void clickCheckAvailabiltyButton() throws Exception {
        click(checkAvailabiltyButton, "Check Availability");
    }

    public void checkAvailabilityMessage(String message) throws Exception {
        Thread.sleep(5000);
        String fetched = getTextofElement(checkAvailabilityMessage, message);
        Assert.assertEquals(message, fetched);
    }

    public void enterpassword(String name) throws Exception {
        typeIntoElement(newpassword, name, "passwordfield");
    }

    public void retypepassword(String name) throws Exception {
        typeIntoElement(reenterpassword, name, "retypepasswordfield");
    }

    public void alternateEmailID(String name) throws Exception {
        typeIntoElement(alternateEmailfield, name, "alternateEmailID");
    }

    public void mobilenofield(String name) throws Exception {
        typeIntoElement(mobNo, name, "mobilenofield");
    }

    public void clickGenderButton(String gender) throws Exception {
        click(this.gender, "gender");

    }

    public void selectccountry(String name) throws Exception {
        selectDropDownValue(country, name, "India");
    }

    public void selectcity(String name) throws Exception {
        selectDropDownValue(city, name, "Bangalore");
    }

    public void selectDateOfBirth(String day, String month, String year) throws Exception {
        selectDropDownValue(dayDropdown, day, day);
        selectDropDownValue(monthDropdown, month, month);
        selectDropDownValue(yearDropdown, year, year);
    }

}
