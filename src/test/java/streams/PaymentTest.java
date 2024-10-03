package streams;

import com.udemy.lambda.functional_interfaces.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.function.Consumer;

import static java.lang.Thread.sleep;
import static streams.PaymentActions.*;

public class PaymentTest {
    private WebDriver driver;
    private PaymentPage paymentPage;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("edge") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        this.paymentPage = new PaymentPage(driver);
    }

    @Test(dataProvider = "criteria")
    public void testPayment(Consumer<PaymentPage> consumer) throws InterruptedException {
        this.paymentPage.goTo();
        consumer.accept(paymentPage);
        sleep(4000);
    }

    @DataProvider(name = "criteria")
    public Object[][] testData() {
        return new Object[][]{
                {freeCoupon.andThen(buy).andThen(success)},
                {partialCoupon.andThen(buy).andThen(fail)},
                {partialCoupon.andThen(invalidCC).andThen(buy).andThen(fail)},
                {validCC.andThen(buy).andThen(success)},
                {invalidCC.andThen(buy).andThen(success)},
                {emptyCC.andThen(buy).andThen(fail)},
        };
    }

    @AfterTest
    public void quit() {
        this.driver.quit();
    }

}
