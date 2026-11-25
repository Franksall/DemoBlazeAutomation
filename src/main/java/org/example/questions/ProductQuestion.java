package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.example.pages.ProductPage;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductQuestion {

    private static WebDriverWait explicitWait(Actor actor) {

        WebDriverWait wait = new WebDriverWait(
                BrowseTheWeb.as(actor).getDriver(),
                Duration.ofSeconds(15)
        );

        wait.ignoring(StaleElementReferenceException.class);

        return wait;
    }

    public static Question<String> name() {

        return actor -> explicitWait(actor).until(driver -> {

            String name = ProductPage.PRODUCT_NAME
                    .resolveFor(actor)
                    .getText()
                    .trim();

            return name.isEmpty() ? null : name;
        });
    }

    public static Question<Integer> price() {

        return actor -> explicitWait(actor).until(driver -> {

            String price = ProductPage.PRODUCT_PRICE
                    .resolveFor(actor)
                    .getText();

            Matcher matcher = Pattern.compile("\\$\\s*(\\d+)")
                    .matcher(price);

            return matcher.find()
                    ? Integer.parseInt(matcher.group(1))
                    : null;
        });
    }

    public static Question<Boolean> descriptionIsVisible() {

        return actor -> explicitWait(actor).until(driver ->
                ProductPage.PRODUCT_DESCRIPTION
                        .resolveFor(actor).isVisible()
                        && !ProductPage.PRODUCT_DESCRIPTION
                        .resolveFor(actor).getText().isBlank()
        );
    }

    public static Question<Boolean> imageIsVisible() {

        return actor -> explicitWait(actor).until(driver -> {

            var image = ProductPage.PRODUCT_IMAGE
                    .resolveFor(actor);

            String width = image.getAttribute("naturalWidth");

            return image.isVisible()
                    && width != null
                    && Integer.parseInt(width) > 0;
        });
    }

    public static Question<Boolean> addToCartIsEnabled() {

        return actor -> explicitWait(actor).until(driver ->
                ProductPage.BTN_ADD_TO_CART
                        .resolveFor(actor).isVisible()
                        && ProductPage.BTN_ADD_TO_CART
                        .resolveFor(actor).isEnabled()
        );
    }
}
