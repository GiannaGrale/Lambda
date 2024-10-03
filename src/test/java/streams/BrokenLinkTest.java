package streams;

import com.udemy.lambda.functional_interfaces.supplier.DriverFactory;
import com.udemy.util.LinkUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.stream.Collectors;

public class BrokenLinkTest {

    private WebDriver driver;
    private TableDemoPage tableDemoPage;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("edge") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        this.tableDemoPage = new TableDemoPage(driver);
    }

    @Test
    public void linkTest() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");
        List<String> result = this.driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .map(e -> e.getAttribute("src"))
                .filter(src -> LinkUtil.getResponseCode(src) != 200)
                .collect(Collectors.toList());
        Assert.assertEquals(result.size(), 0, result.toString());
    }

    @AfterTest
    public void quit() {
        this.driver.quit();
    }
}
