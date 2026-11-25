package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.questions.ProductQuestion;
import org.example.tasks.SelectProduct;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class ProductSteps {

    @When("el usuario selecciona el producto {string}")
    public void elUsuarioSeleccionaElProducto(String product) {

        theActorInTheSpotlight().attemptsTo(
                SelectProduct.called(product)
        );
    }

    @Then("el usuario visualiza el detalle del producto {string}")
    public void elUsuarioVisualizaElDetalleDelProducto(String product) {

        theActorInTheSpotlight().should(
                seeThat(
                        ProductQuestion.name(),
                        equalTo(product)
                )
        );
    }

    @Then("el usuario verifica que el precio del producto sea {int} dolares")
    public void elUsuarioVerificaElPrecioDelProducto(int price) {

        theActorInTheSpotlight().should(
                seeThat(
                        ProductQuestion.price(),
                        equalTo(price)
                )
        );
    }

    @Then("el usuario visualiza la descripcion del producto")
    public void elUsuarioVisualizaLaDescripcionDelProducto() {

        theActorInTheSpotlight().should(
                seeThat(
                        ProductQuestion.descriptionIsVisible(),
                        equalTo(true)
                )
        );
    }

    @Then("el usuario visualiza la imagen del producto")
    public void elUsuarioVisualizaLaImagenDelProducto() {

        theActorInTheSpotlight().should(
                seeThat(
                        ProductQuestion.imageIsVisible(),
                        equalTo(true)
                )
        );
    }

    @Then("el usuario visualiza el boton agregar al carrito habilitado")
    public void elUsuarioVisualizaElBotonAgregarAlCarritoHabilitado() {

        theActorInTheSpotlight().should(
                seeThat(
                        ProductQuestion.addToCartIsEnabled(),
                        equalTo(true)
                )
        );
    }
}
