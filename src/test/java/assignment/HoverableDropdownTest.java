package assignment;

import com.udemy.lambda.functional_interfaces.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import streams.SearchCriteriaFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

public class HoverableDropdownTest {
    private WebDriver driver;
    private Actions actions;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("edge") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        this.actions = new Actions(driver);
    }

    @Test(dataProvider = "linkProvider")
    public void dropdownTest(String text) throws InterruptedException {
        String[] path = text.split("=>");
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/drop-down.html");
        Arrays.stream(path)
                .map(s -> s.trim())
                .map(s -> By.linkText(s))
                .map(by -> driver.findElement(by))
                .map(element -> actions.moveToElement(element))
                .forEach(actions1 -> actions1.perform());
        sleep(3000);

    }

    @DataProvider(name = "linkProvider")
    public Object[][] testData() {
        return new Object[][]{
                {"Dropdown => Dropdown Link 2"},
                {"Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.1"},
                {"Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.4 => Dropdown Submenu Link 5.4.2"},
        };
    }

    @AfterTest
    public void quit() {
        this.driver.quit();
    }
}
