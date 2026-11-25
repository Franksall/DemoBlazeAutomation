package org.example.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.pages.HomePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class NavigateCatalog {

    public static Performable nextPage() {
        return Task.where(
                "{0} navega a la siguiente pagina del catalogo",
                WaitUntil.the(HomePage.BTN_NEXT, isClickable())
                        .forNoMoreThan(15).seconds(),
                Click.on(HomePage.BTN_NEXT)
        );
    }

    public static Performable previousPage() {
        return Task.where(
                "{0} regresa a la pagina anterior del catalogo",
                WaitUntil.the(HomePage.BTN_PREVIOUS, isClickable())
                        .forNoMoreThan(15).seconds(),
                Click.on(HomePage.BTN_PREVIOUS)
        );
    }
}