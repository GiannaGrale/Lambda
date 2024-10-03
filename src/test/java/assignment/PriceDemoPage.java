package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PriceDemoPage {

    private WebDriver driver;

    public PriceDemoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-price.html");
    }

    public void selectMinRow() {
        Optional<List<WebElement>> minValue =
                this.driver.findElements(By.cssSelector("table#prods tr"))
                        .stream()
                        .skip(1)
                        .map(tr -> tr.findElements(By.tagName("td")))
                        .min(Comparator.comparing(l -> Integer.parseInt(l.get(2).getText())));

        minValue.ifPresent(elements -> elements.get(3).findElement(By.tagName("input")).click());
    }

    public void clickVerify() {
        driver.findElement(By.id("result")).click();
    }

    public String getStatus() {
        return driver.findElement(By.id("status")).getText();
    }
}
