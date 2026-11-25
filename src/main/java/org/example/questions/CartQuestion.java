package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.example.pages.CartPage;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartQuestion {

    private static WebDriverWait explicitWait(Actor actor) {

        WebDriverWait wait = new WebDriverWait(
                BrowseTheWeb.as(actor).getDriver(),
                Duration.ofSeconds(15)
        );

        wait.ignoring(StaleElementReferenceException.class);

        return wait;
    }

    public static Question<String> confirmationMessage() {

        return actor -> actor.recall("cartAlertMessage");
    }

    public static Question<Boolean> productIsVisible(String product) {

        return actor -> explicitWait(actor).until(driver ->
                CartPage.CART_PRODUCT.of(product)
                        .resolveFor(actor).isVisible()
        );
    }

    public static Question<Boolean> totalIs(int expectedTotal) {

        return actor -> explicitWait(actor).until(driver -> {

            String total = CartPage.TOTAL_PRICE
                    .resolveFor(actor)
                    .getText()
                    .trim();

            return total.equals(String.valueOf(expectedTotal));
        });
    }

    public static Question<Boolean> cartIsEmpty() {

        return actor -> explicitWait(actor).until(driver -> {

            boolean noProducts = CartPage.PRODUCT_ROWS
                    .resolveAllFor(actor)
                    .isEmpty();

            String total = CartPage.TOTAL_PRICE
                    .resolveFor(actor)
                    .getText()
                    .trim();

            return noProducts
                    && (total.isEmpty() || total.equals("0"));
        });
    }
}
