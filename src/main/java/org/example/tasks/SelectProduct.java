package org.example.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.pages.HomePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SelectProduct {

    public static Performable called(String product) {
        return Task.where(
                "{0} selecciona el producto " + product,

                WaitUntil.the(
                        HomePage.PRODUCT.of(product),
                        isClickable()
                ).forNoMoreThan(15).seconds(),

                Click.on(HomePage.PRODUCT.of(product))
        );
    }
}
