package definitions;

import com.google.common.io.Files;
import enums.WebElementStates;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static definitions.BaseDefinitions.chromeDriver;

public class LoginTestDefinitions {


    @Given("I open the Login page")
    public void openLoginPage() {
        chromeDriver.get("https://account.battle.net/");
    }


    @When("I enter {string} my email on the Login page")
    public void enterEmail(String email) {
        chromeDriver.findElement(By.id("accountName")).sendKeys(email);
    }

    @When("I enter {string} my password on the Login page")
    public void enterPass(String pass) {
        chromeDriver.findElement(By.id("password")).sendKeys(pass);
    }

    @When("I click on submit button on the Login page")
    public void clickOnSubmitButton() throws InterruptedException {
        Thread.sleep(1000);
        chromeDriver.findElement(By.id("submit")).click();
    }

    @Then("The main page is displayed")
    public void verifyMainPage() {
        WebElement mainPage = new WebDriverWait(
                chromeDriver,
                Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.id("app"))
        );

        Assertions.assertTrue(mainPage.isDisplayed());
    }

    @Given("I login into the system")
    public void login() throws InterruptedException {
        enterEmail("anton.makovetskyi@gmail.com");
        enterPass("Art123456!");
        clickOnSubmitButton();
        verifyMainPage();
    }

    @After
    public void afterFailScenario(Scenario scenario) throws IOException {

        if(scenario.isFailed()) {
            byte[] screenBytes = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenBytes, "image/png", scenario.getName() + ".png");
            File scrFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(scenario.getName() + ".png"));
        }
    }


}
