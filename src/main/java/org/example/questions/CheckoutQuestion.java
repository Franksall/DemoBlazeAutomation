package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.example.pages.CheckoutPage;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckoutQuestion {

    private static WebDriverWait explicitWait(Actor actor) {

        WebDriverWait wait = new WebDriverWait(
                BrowseTheWeb.as(actor).getDriver(),
                Duration.ofSeconds(15)
        );

        wait.ignoring(StaleElementReferenceException.class);

        return wait;
    }

    public static Question<Boolean> purchaseIsSuccessful() {

        return actor -> explicitWait(actor).until(driver ->
                CheckoutPage.SUCCESS_MESSAGE
                        .resolveFor(actor).isVisible()
        );
    }

    public static Question<String> alertMessage() {

        return actor -> actor.recall("checkoutAlertMessage");
    }

    public static Question<Integer> purchaseAmount() {

        return actor -> explicitWait(actor).until(driver -> {

            String details = CheckoutPage.PURCHASE_DETAILS
                    .resolveFor(actor)
                    .getText();

            Matcher matcher = Pattern
                    .compile("Amount:\\s*(\\d+)")
                    .matcher(details);

            return matcher.find()
                    ? Integer.parseInt(matcher.group(1))
                    : null;
        });
    }
}
