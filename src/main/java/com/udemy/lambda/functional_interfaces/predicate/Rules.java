package com.udemy.lambda.functional_interfaces.predicate;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Rules {

    private static Predicate<WebElement> isBlank = (element) -> element.getText().trim().length()==0;
    private static Predicate<WebElement> isLetterS= (element) -> element.getText().toLowerCase().contains("с");

    public static List<Predicate<WebElement>> get(){
        List<Predicate<WebElement>> r = new ArrayList<>();
        r.add(isBlank);
        r.add(isLetterS);
        return r;
    }
}
