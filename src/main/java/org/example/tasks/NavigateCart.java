package org.example.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.pages.HomePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class NavigateCart {

    public static Performable toCart() {

        return Task.where(
                "{0} accede al carrito de compras",

                WaitUntil.the(
                        HomePage.BTN_CART,
                        isClickable()
                ).forNoMoreThan(15).seconds(),

                Click.on(HomePage.BTN_CART)
        );
    }
}
