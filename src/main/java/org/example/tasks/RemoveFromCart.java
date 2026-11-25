
package org.example.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.pages.CartPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class RemoveFromCart {

    public static Performable product(String product) {

        return Task.where(
                "{0} elimina del carrito el producto " + product,

                WaitUntil.the(
                        CartPage.BTN_DELETE.of(product),
                        isClickable()
                ).forNoMoreThan(15).seconds(),

                Click.on(CartPage.BTN_DELETE.of(product)),

                WaitUntil.the(
                        CartPage.CART_PRODUCT.of(product),
                        isNotVisible()
                ).forNoMoreThan(15).seconds()
        );
    }
}
