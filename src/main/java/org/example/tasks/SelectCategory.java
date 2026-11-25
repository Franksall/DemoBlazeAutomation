package org.example.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.pages.HomePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SelectCategory {

    public static Performable called(String category) {
        return Task.where(
                "{0} selecciona la categoria " + category,
                WaitUntil.the(HomePage.CATEGORY.of(category), isClickable())
                        .forNoMoreThan(15).seconds(),
                Click.on(HomePage.CATEGORY.of(category))
        );
    }
}
