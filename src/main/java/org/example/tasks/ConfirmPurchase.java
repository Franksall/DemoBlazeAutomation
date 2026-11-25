package org.example.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.pages.CheckoutPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ConfirmPurchase {

    public static Performable now() {

        return Task.where(
                "{0} confirma la compra",

                WaitUntil.the(
                        CheckoutPage.BTN_PURCHASE,
                        isClickable()
                ).forNoMoreThan(15).seconds(),

                Click.on(CheckoutPage.BTN_PURCHASE)
        );
    }
}
