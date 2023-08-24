package definitions;

import enums.WebElementStates;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static definitions.BaseDefinitions.chromeDriver;

public class MenuTestDefinitions {

    @When("The following items are '{}' on the menu widget")
    public void verifyMenuItemsVisibility(WebElementStates webElementState, List<String> expectedMenuItemsName) {
        List<WebElement> menuItems =
                chromeDriver.findElements(By.xpath("//div[@class='side-navigation desktop']//span[text()]"));

        List<String> actualMenuItemsName = menuItems
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        Assertions.assertEquals(webElementState.getValue(), actualMenuItemsName.containsAll(expectedMenuItemsName));
    }
}
