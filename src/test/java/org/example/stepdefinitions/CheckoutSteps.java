package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.interactions.AcceptCheckoutAlert;
import org.example.questions.CheckoutQuestion;
import org.example.tasks.OpenCheckout;
import org.example.tasks.FillPurchaseForm;
import org.example.tasks.ConfirmPurchase;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSteps {

    @When("el usuario abre el formulario de compra")
    public void elUsuarioAbreElFormularioDeCompra() {

        theActorInTheSpotlight().attemptsTo(
                OpenCheckout.form()
        );
    }

    @When("el usuario completa el formulario con los datos {string}, {string}, {string}, {string}, {string}, {string}")
    public void elUsuarioCompletaElFormulario(
            String name,
            String country,
            String city,
            String card,
            String month,
            String year) {

        theActorInTheSpotlight().attemptsTo(
                FillPurchaseForm.withData(
                        name,
                        country,
                        city,
                        card,
                        month,
                        year
                )
        );
    }

    @When("el usuario confirma la compra")
    public void elUsuarioConfirmaLaCompra() {

        theActorInTheSpotlight().attemptsTo(
                ConfirmPurchase.now()
        );
    }

    @Then("el usuario visualiza el mensaje de compra exitosa")
    public void elUsuarioVisualizaElMensajeDeCompraExitosa() {

        theActorInTheSpotlight().should(
                seeThat(
                        CheckoutQuestion.purchaseIsSuccessful(),
                        equalTo(true)
                )
        );
    }

    @Then("el usuario visualiza una alerta con el mensaje {string}")
    public void elUsuarioVisualizaUnaAlerta(String message) {

        theActorInTheSpotlight().attemptsTo(
                AcceptCheckoutAlert.now()
        );

        theActorInTheSpotlight().should(
                seeThat(
                        CheckoutQuestion.alertMessage(),
                        equalTo(message)
                )
        );
    }

    @Then("el usuario verifica que el importe de la compra sea {int} dolares")
    public void elUsuarioVerificaElImporteDeLaCompra(int amount) {

        theActorInTheSpotlight().should(
                seeThat(
                        CheckoutQuestion.purchaseAmount(),
                        equalTo(amount)
                )
        );
    }
}
