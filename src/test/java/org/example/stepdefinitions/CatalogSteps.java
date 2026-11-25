package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.questions.CatalogQuestion;
import org.example.tasks.NavigateCatalog;
import org.example.tasks.SelectCategory;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;

public class CatalogSteps {

    @Then("el usuario visualiza las categorias disponibles")
    public void elUsuarioVisualizaLasCategoriasDisponibles() {

        theActorInTheSpotlight().should(
                seeThat(
                        CatalogQuestion.categoriesAreVisible(),
                        equalTo(true)
                )
        );
    }

    @Then("el usuario visualiza productos en el catalogo")
    public void elUsuarioVisualizaProductosEnElCatalogo() {

        theActorInTheSpotlight().should(
                seeThat(
                        CatalogQuestion.products(),
                        not(empty())
                )
        );
    }

    @When("el usuario selecciona la categoria {string}")
    public void elUsuarioSeleccionaLaCategoria(String category) {

        theActorInTheSpotlight().attemptsTo(
                SelectCategory.called(category)
        );
    }

    @Then("el usuario visualiza el producto {string}")
    public void elUsuarioVisualizaElProducto(String product) {

        theActorInTheSpotlight().should(
                seeThat(
                        CatalogQuestion.productIsVisible(product),
                        equalTo(true)
                )
        );
    }

    @When("el usuario selecciona el boton siguiente")
    public void elUsuarioSeleccionaElBotonSiguiente() {

        List<String> firstPage = theActorInTheSpotlight()
                .asksFor(CatalogQuestion.products());

        theActorInTheSpotlight().remember(
                "firstPage", firstPage
        );

        theActorInTheSpotlight().attemptsTo(
                NavigateCatalog.nextPage()
        );
    }

    @Then("el usuario visualiza una nueva pagina de productos")
    public void elUsuarioVisualizaUnaNuevaPaginaDeProductos() {

        List<String> firstPage = theActorInTheSpotlight()
                .recall("firstPage");

        theActorInTheSpotlight().should(
                seeThat(
                        CatalogQuestion.pageHasChanged(firstPage),
                        equalTo(true)
                )
        );
    }


    @When("el usuario selecciona el boton anterior")
    public void elUsuarioSeleccionaElBotonAnterior() {

        List<String> secondPage = theActorInTheSpotlight()
                .asksFor(CatalogQuestion.productsOnCurrentPage());

        theActorInTheSpotlight().remember(
                "secondPage", secondPage
        );

        theActorInTheSpotlight().attemptsTo(
                NavigateCatalog.previousPage()
        );
    }

    @Then("el usuario visualiza los productos de la pagina anterior")
    public void elUsuarioVisualizaLosProductosDeLaPaginaAnterior() {

        List<String> secondPage = theActorInTheSpotlight()
                .recall("secondPage");

        theActorInTheSpotlight().should(
                seeThat(
                        CatalogQuestion.previousPageIsVisible(secondPage),
                        equalTo(true)
                )
        );
    }

}
