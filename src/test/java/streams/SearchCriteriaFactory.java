package streams;

import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class SearchCriteriaFactory {
    private static Predicate<List<WebElement>> allMale = (l) -> l.get(1).getText().equalsIgnoreCase("male");
    private static Predicate<List<WebElement>> allFemale = (l) -> l.get(1).getText().equalsIgnoreCase("female");
    private static Predicate<List<WebElement>> allGender = allMale.or(allFemale);
    private static Predicate<List<WebElement>> usa = (l) -> l.get(2).getText().equalsIgnoreCase("USA");
    private static Predicate<List<WebElement>> allFemaleUsa = allFemale.and(usa);

    private static final Map<String, Predicate<List<WebElement>>> MAP = new HashMap<>();

    static {
        MAP.put("allMale", allMale);
        MAP.put("allFemale", allFemale);
        MAP.put("allGender", allGender);
        MAP.put("usa", usa);
        MAP.put("allFemaleUsa", allFemaleUsa);
    }

    public static Predicate<List<WebElement>> getCriteria (String criteria){
        return MAP.get(criteria);
    }
}
