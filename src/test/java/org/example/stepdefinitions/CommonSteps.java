package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import org.example.tasks.NavigateHome;

public class CommonSteps {

    @Given("el {actor} esta en la pagina de inicio")
    public void elUsuarioEstaEnLaPaginaDeInicio(Actor actor) {
        actor.attemptsTo(
                NavigateHome.theHomePage()
        );
    }
}
