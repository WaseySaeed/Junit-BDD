package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class initHookSteps {
    public static WebDriver driver;

    @Before
    public void setup() {
        setDriver();
    }

    @Given("Starting the browser")
    public void startingBrowser() {
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login.");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void SetupAfterEveryTest() {
        driver.close();
        driver.quit();
    }

    public WebDriver setDriver() {
        driver = new ChromeDriver();
        return driver;
    }
}
