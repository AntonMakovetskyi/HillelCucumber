package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDefinitions {

    public static WebDriver chromeDriver;

    @Before(order = 0)
    public void init() {
        System.out.println("Test started");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }


    @After
    public void quite() {
        chromeDriver.quit();
    }
}
