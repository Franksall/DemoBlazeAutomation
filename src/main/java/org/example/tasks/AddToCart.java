package org.example.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.interactions.AcceptCartAlert;
import org.example.pages.ProductPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AddToCart {

    public static Performable product() {

        return Task.where(
                "{0} agrega el producto al carrito",

                WaitUntil.the(
                        ProductPage.BTN_ADD_TO_CART,
                        isClickable()
                ).forNoMoreThan(15).seconds(),

                Click.on(ProductPage.BTN_ADD_TO_CART),

                AcceptCartAlert.now()
        );
    }
}
