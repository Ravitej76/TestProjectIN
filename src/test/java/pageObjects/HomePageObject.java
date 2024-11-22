package pageObjects;

import Utilities.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BaseTest {
    BaseTest utility;
    private WebDriver driver;

    //Declaration
    @FindBy(xpath = "//span[.='Hello, sign in']")
    private WebElement userSignIn;

    @FindBy(xpath = "//span[@class='nav-action-inner']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    private WebElement userdetails;


    //Initiliazation
    public HomePageObject(){
        this.driver = openBrowser();
        PageFactory.initElements(driver, this);
    }

    //Utilization
    public void openBrowserAndclickSignInButton(){
        utility = new BaseTest();
        utility.openBrowser();
        Actions act = new Actions(driver);
        act.moveToElement(userSignIn).perform();
        signInButton.click();
    }

    public void verifyUserloggedInSuccessfully(){
        String expectedUsername = "Hello, Raviteja";
        String fetchedUsername = userdetails.getText();
        Assert.assertEquals(expectedUsername,fetchedUsername);
    }

}
