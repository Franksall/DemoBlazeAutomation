package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.core.pages.WebElementFacade;
import org.example.pages.HomePage;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogQuestion {

    private static WebDriverWait explicitWait(Actor actor) {
        WebDriverWait wait = new WebDriverWait(
                BrowseTheWeb.as(actor).getDriver(),
                Duration.ofSeconds(15)
        );

        wait.ignoring(StaleElementReferenceException.class);

        return wait;
    }

    private static List<String> readProducts(Actor actor) {
        return HomePage.PRODUCT_LIST
                .resolveAllFor(actor)
                .stream()
                .map(WebElementFacade::getText)
                .filter(name -> !name.isBlank())
                .sorted()
                .collect(Collectors.toList());
    }

    public static Question<Boolean> categoriesAreVisible() {
        return actor -> explicitWait(actor).until(driver ->
                HomePage.CATEGORY_PHONES.resolveFor(actor).isVisible()
                        && HomePage.CATEGORY_LAPTOPS.resolveFor(actor).isVisible()
                        && HomePage.CATEGORY_MONITORS.resolveFor(actor).isVisible()
        );
    }

    public static Question<List<String>> products() {
        return actor -> explicitWait(actor).until(driver -> {

            List<String> products = readProducts(actor);

            return products.size() == 9 ? products : null;
        });
    }

    public static Question<Boolean> productIsVisible(String product) {
        return actor -> explicitWait(actor).until(driver ->
                HomePage.PRODUCT.of(product)
                        .resolveFor(actor).isVisible()
        );
    }

    public static Question<Boolean> pageHasChanged(
            List<String> previousProducts) {

        return actor -> explicitWait(actor).until(driver -> {

            List<String> currentProducts = readProducts(actor);

            return !currentProducts.isEmpty()
                    && currentProducts.stream()
                    .noneMatch(previousProducts::contains);
        });
    }


    public static Question<List<String>> productsOnCurrentPage() {
        return actor -> explicitWait(actor).until(driver -> {

            List<String> products = readProducts(actor);

            return products.size() == 6 ? products : null;
        });
    }

    public static Question<Boolean> previousPageIsVisible(
            List<String> secondPage) {

        return actor -> explicitWait(actor).until(driver -> {

            List<String> currentProducts = readProducts(actor);

            return currentProducts.size() == 9
                    && !currentProducts.equals(secondPage);
        });
    }

}
