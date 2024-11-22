package pageObjects;

import Utilities.BaseTest;
import Utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class  LoginPageObject extends BaseTest {


    //Declaration
   @FindBy(id = "ap_email")
    private WebElement emailOrPhoneField;

   @FindBy(id = "continue")
   private WebElement continueButton;

   @FindBy(id = "ap_password")
    private WebElement passwordfield;

   @FindBy(id = "signInSubmit")
    private WebElement signInButton;

    //Initiliazation
    public LoginPageObject(){
        PageFactory.initElements(driver,this);
    }

    //Utilization
    public void loginToAmazon() throws Exception {
        typeIntoElement(emailOrPhoneField,ConfigurationReader.getProperty("username"),"Email");
        continueButton.click();
        typeIntoElement(passwordfield,ConfigurationReader.getProperty("password"),"Password");
        signInButton.click();
        Thread.sleep(15000);
    }

}
