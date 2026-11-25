package org.example.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.pages.CheckoutPage;

public class FillPurchaseForm {

    public static Performable withData(
            String name,
            String country,
            String city,
            String card,
            String month,
            String year) {

        return Task.where(
                "{0} completa el formulario de compra",

                Enter.theValue(name)
                        .into(CheckoutPage.INP_NAME),

                Enter.theValue(country)
                        .into(CheckoutPage.INP_COUNTRY),

                Enter.theValue(city)
                        .into(CheckoutPage.INP_CITY),

                Enter.theValue(card)
                        .into(CheckoutPage.INP_CARD),

                Enter.theValue(month)
                        .into(CheckoutPage.INP_MONTH),

                Enter.theValue(year)
                        .into(CheckoutPage.INP_YEAR)
        );
    }
}
