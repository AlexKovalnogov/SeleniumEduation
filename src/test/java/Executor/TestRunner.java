package Executor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ua.kovalnohov.pages.HomePage;

import java.util.concurrent.TimeUnit;

public class TestRunner extends Vars {
    protected WebDriver driver;

    @Before
    public void beforeTest() {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
    }


    @After
    public void afterTest() {
        driver.quit();
    }
}
