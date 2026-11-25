package org.example.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AcceptCartAlert implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriverWait wait = new WebDriverWait(
                BrowseTheWeb.as(actor).getDriver(),
                Duration.ofSeconds(15)
        );

        Alert alert = wait.until(
                ExpectedConditions.alertIsPresent()
        );

        actor.remember("cartAlertMessage", alert.getText());

        alert.accept();
    }

    public static Interaction now() {
        return new AcceptCartAlert();
    }
}
