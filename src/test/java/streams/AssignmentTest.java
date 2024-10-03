package streams;

import com.udemy.lambda.functional_interfaces.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.function.Predicate;

public class AssignmentTest {
    private WebDriver driver;
    private TableDemoPage tableDemoPage;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("edge") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        this.tableDemoPage = new TableDemoPage(driver);
    }

    @Test
    public void assignmentTest1() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
        this.driver.findElements(By.xpath("//input[@type='checkbox']")).forEach(WebElement::click);
    }


    @Test(dataProvider = "gender")
    public void assignCheckbox(Predicate<List<WebElement>> criteria) {
        tableDemoPage.goTo();
        tableDemoPage.selectRows(criteria);
    }

    @DataProvider(name = "gender")
    public Object[][] testData() {
        return new Object[][]{
                {SearchCriteriaFactory.getCriteria("allMale")},
                {SearchCriteriaFactory.getCriteria("allFemale")},
                {SearchCriteriaFactory.getCriteria("allGender")},
                {SearchCriteriaFactory.getCriteria("usa")},
                {SearchCriteriaFactory.getCriteria("allFemaleUsa")}
        };
    }

    @AfterTest
    public void quit() {
        this.driver.quit();
    }
}
