package Executor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import ua.kovalnohov.pages.HomePage;

public class TestRunner extends Vars {
    protected WebDriver driver;

    @Before
    public void beforeTest() {
        WebDriverManager.chromedriver()
                .setup();
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
    }


    @After
    public void afterTest() {
        driver.quit();
    }
}
