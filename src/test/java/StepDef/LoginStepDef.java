package StepDef;

import Utilities.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

public class LoginStepDef {
    HomePageObject homePageObject;
    LoginPageObject loginPage;
    BaseTest utility;

    @Given("user is on homepage to login")
    public void user_is_on_homepage_to_login() {
        homePageObject = new HomePageObject();
        homePageObject.openBrowserAndclickSignInButton();
    }
    @Then("user login with valid credentials")
    public void user_login_with_valid_credentials() throws Exception {
        loginPage = new LoginPageObject();
        loginPage.loginToAmazon();

    }
    @Then("verify user should land on homepage")
    public void verify_user_should_land_on_homepage() {
        homePageObject.verifyUserloggedInSuccessfully();
    }

    @Then("close the Browser")
    public void close_the_browser() {
        utility = new BaseTest();
        utility.closeBrowser();

    }
}
