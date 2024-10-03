package assignment;

import com.udemy.lambda.functional_interfaces.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ThirdAssignment {

    private WebDriver driver;
    private PriceDemoPage priceDemoPage;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("edge") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        this.priceDemoPage = new PriceDemoPage(driver);
    }

    @Test
    public void assignmentTest() {
        priceDemoPage.goTo();
        priceDemoPage.selectMinRow();
        priceDemoPage.clickVerify();
        Assert.assertEquals(priceDemoPage.getStatus(), "PASS");
    }
    @AfterTest
    public void quit() {
        this.driver.quit();
    }
}
