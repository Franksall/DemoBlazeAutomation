package org.example.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.pages.CartPage;
import org.example.pages.CheckoutPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OpenCheckout {

    public static Performable form() {

        return Task.where(
                "{0} abre el formulario de compra",

                WaitUntil.the(
                        CartPage.BTN_PLACE_ORDER,
                        isClickable()
                ).forNoMoreThan(15).seconds(),

                Click.on(CartPage.BTN_PLACE_ORDER),

                WaitUntil.the(
                        CheckoutPage.ORDER_MODAL,
                        isVisible()
                ).forNoMoreThan(15).seconds(),

                WaitUntil.the(
                        CheckoutPage.INP_NAME,
                        isClickable()
                ).forNoMoreThan(15).seconds()
        );
    }
}
