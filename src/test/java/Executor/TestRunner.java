package Executor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class TestRunner {


    @Before
public void beforeTest(){
        WebDriver driver = WebDriverManager.chromedriver()
                .create();
        driver.get("https://magento.softwaretestingboard.com/");

    }



    @After
    public void afterTest(){}
}
