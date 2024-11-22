package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    private WebElement element;

    public static WebDriver openBrowser(){
        if(driver == null){
           String browser = ConfigurationReader.getProperty("browser");
           switch(browser){
               case "chrome":
                   WebDriverManager.chromedriver().setup();
                   driver = new ChromeDriver();
                   break;
               case "edge":
                   WebDriverManager.edgedriver().setup();
                   driver = new EdgeDriver();
                   break;
               default:
                   System.out.println("Invalid Browser...");
                   break;
           }
            driver.manage().window().maximize();
            driver.get(ConfigurationReader.getProperty("url"));
       }
        return driver;
    }

    public void closeBrowser(){
        driver.quit();
    }

    public void click(final WebElement element, final String name) throws Exception {
        try {
            Thread.sleep(1000);
            try {
                highlightElement(element);
            } catch (Exception e) {
                System.out.println("Unable to highlight element.");
            }
            element.click();
        } catch (Exception e) {
            throw new Exception("Unable to click the element: " + name, e);
        }
    }

    public void highlightElement(final WebElement element) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var viewPortHeight = Math.max(document.documentElement.clientHeight,"
                + " window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));", element);
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
                "color: Green; border: 2px solid yellow;");
    }

    public void waitUntilWebElementVisible(final WebElement element, final int timeInsec)
            throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInsec));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            throw new Exception("Function waitUntilWebElementVisible is timed out.", e);
        }
    }

    public void typeIntoElement(WebElement element, String whatTOType, String name) throws Exception {
        try{
            highlightElement(element);
            element.sendKeys(whatTOType);
        }catch (Exception e){
            throw new Exception("Unable to type: " +name);
        }
    }

    public String getTextofElement(WebElement element, String name) throws Exception {
        String value;
        try{
            highlightElement(element);
            value = element.getText();
        } catch (Exception e) {
            throw new Exception("Unable to get text: " +name);
        }
        return value;
    }

    public WebElement selectDropDownValue(WebElement element, String whatToSelect, String name) throws Exception {
        try{
            highlightElement(element);
            new Select(element).selectByVisibleText(whatToSelect);
        } catch (Exception e) {
            throw new Exception("Unable to select: " +name);
        }
        return element;
    }

    public void assertTextEquals(String actualText, String expectedText, String message) {
        try {
            Assert.assertEquals(actualText, expectedText, message);
            System.out.println("Assertion Passed: " + message);
        } catch (AssertionError e) {
            System.err.println("Assertion Failed: " + message);
            throw e;
        }
    }
}






