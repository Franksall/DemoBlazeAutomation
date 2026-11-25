package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.questions.CartQuestion;
import org.example.tasks.AddToCart;
import org.example.tasks.NavigateCart;
import org.example.tasks.NavigateHome;
import org.example.tasks.RemoveFromCart;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class CartSteps {

    @When("el usuario agrega el producto al carrito")
    public void elUsuarioAgregaElProductoAlCarrito() {

        theActorInTheSpotlight().attemptsTo(
                AddToCart.product()
        );

        theActorInTheSpotlight().should(
                seeThat(
                        CartQuestion.confirmationMessage(),
                        equalTo("Product added")
                )
        );
    }

    @When("el usuario accede al carrito de compras")
    public void elUsuarioAccedeAlCarritoDeCompras() {

        theActorInTheSpotlight().attemptsTo(
                NavigateCart.toCart()
        );
    }

    @When("el usuario regresa a la pagina de inicio")
    public void elUsuarioRegresaALaPaginaDeInicio() {

        theActorInTheSpotlight().attemptsTo(
                NavigateHome.theHomePage()
        );
    }

    @When("el usuario elimina el producto {string} del carrito")
    public void elUsuarioEliminaElProductoDelCarrito(String product) {

        theActorInTheSpotlight().attemptsTo(
                RemoveFromCart.product(product)
        );
    }

    @Then("el usuario visualiza el producto {string} en el carrito")
    public void elUsuarioVisualizaElProductoEnElCarrito(String product) {

        theActorInTheSpotlight().should(
                seeThat(
                        CartQuestion.productIsVisible(product),
                        equalTo(true)
                )
        );
    }

    @Then("el usuario verifica que el total del carrito sea {int} dolares")
    public void elUsuarioVerificaElTotalDelCarrito(int total) {

        theActorInTheSpotlight().should(
                seeThat(
                        CartQuestion.totalIs(total),
                        equalTo(true)
                )
        );
    }

    @Then("el usuario verifica que el carrito este vacio")
    public void elUsuarioVerificaQueElCarritoEsteVacio() {

        theActorInTheSpotlight().should(
                seeThat(
                        CartQuestion.cartIsEmpty(),
                        equalTo(true)
                )
        );
    }
}
