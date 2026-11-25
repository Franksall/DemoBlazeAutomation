package org.example.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import org.example.pages.HomePage;

public class NavigateHome {

    public static Performable theHomePage() {
        return Task.where(
                "{0} navega a la pagina principal de DemoBlaze",
                Open.browserOn().the(HomePage.class)
        );
    }
}
