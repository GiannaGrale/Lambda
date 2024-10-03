package supplier;

import com.udemy.lambda.functional_interfaces.predicate.Rules;
import com.udemy.lambda.functional_interfaces.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

public class DriverTest {
    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void googleTest(){
        this.driver.get("https://www.google.com/");
       List<WebElement> elementList =  this.driver.findElements(By.tagName("a"));

        System.out.println("Before :: " + elementList.size());
        Rules.get().forEach(elementList::removeIf);

        System.out.println("After :: " + elementList.size());
        elementList.forEach(e -> System.out.println(e.getText()));
    }

    @Test
    public void googleStreamTest(){
        this.driver.get("https://www.google.com/");
        this.driver.findElements(By.tagName("a"))
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .filter(element -> !element.contains("с"))
                .filter(element -> element.length() > 0)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @AfterTest
    public void quit(){
        this.driver.quit();
    }
}
