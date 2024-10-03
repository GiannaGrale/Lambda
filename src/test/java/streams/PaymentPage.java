package streams;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    private WebDriver driver;

    @FindBy(id = "coupon")
    private WebElement coupon;

    @FindBy(id = "couponbtn")
    private WebElement couponBtn;

    @FindBy(id = "cc")
    private WebElement creditCard;

    @FindBy(id = "year")
    private WebElement year;

    @FindBy(id = "cvv")
    private WebElement cvv;

    @FindBy(id = "buy")
    private WebElement buyNow;

    @FindBy(id = "status")
    private WebElement status;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-payment-screen.html");
    }

    public void enterCCDetails(String cc, String year, String cvv) {
        this.creditCard.sendKeys(cc);
        this.year.sendKeys(year);
        this.cvv.sendKeys(cvv);
    }

    public void enterPromocodeDetails(String coupon) {
        this.coupon.sendKeys(coupon);
        this.couponBtn.click();
    }

    public void clickBuy() {
        this.buyNow.click();
    }

    public String getStatus() {
        return this.status.getText();
    }
}
