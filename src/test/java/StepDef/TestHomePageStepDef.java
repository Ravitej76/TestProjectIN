package StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestHomePageStepDef {
    public WebDriver driver;

    @Given("user is on home page")
    public void user_is_on_home_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
    }

    @Then("user needs to click on customer service option")
    public void user_needs_to_click_on_customer_service_option() {
        driver.findElement(By.xpath("//a[.='Customer Service']")).click();
    }
}
