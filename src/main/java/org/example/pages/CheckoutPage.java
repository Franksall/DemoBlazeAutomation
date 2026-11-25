package org.example.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {

    public static final Target ORDER_MODAL =
            Target.the("Formulario de compra")
                    .located(By.id("orderModal"));

    public static final Target INP_NAME =
            Target.the("Input nombre")
                    .located(By.id("name"));

    public static final Target INP_COUNTRY =
            Target.the("Input pais")
                    .located(By.id("country"));

    public static final Target INP_CITY =
            Target.the("Input ciudad")
                    .located(By.id("city"));

    public static final Target INP_CARD =
            Target.the("Input tarjeta")
                    .located(By.id("card"));

    public static final Target INP_MONTH =
            Target.the("Input mes")
                    .located(By.id("month"));

    public static final Target INP_YEAR =
            Target.the("Input anio")
                    .located(By.id("year"));

    public static final Target BTN_PURCHASE =
            Target.the("Boton confirmar compra")
                    .located(By.xpath("//button[text()='Purchase']"));

    public static final Target SUCCESS_MESSAGE =
            Target.the("Mensaje de compra exitosa")
                    .located(By.xpath("//h2[text()='Thank you for your purchase!']"));

    public static final Target PURCHASE_DETAILS =
            Target.the("Detalles de la compra")
                    .located(By.cssSelector(".sweet-alert p.lead"));

    public static final Target BTN_OK =
            Target.the("Boton aceptar confirmacion")
                    .located(By.cssSelector(".sweet-alert button.confirm"));
}
