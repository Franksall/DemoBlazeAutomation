package org.example.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {

    public static final Target PRODUCT_ROWS =
            Target.the("Filas de productos del carrito")
                    .located(By.cssSelector("#tbodyid tr"));

    public static final Target CART_PRODUCT =
            Target.the("Producto {0} en el carrito")
                    .locatedBy("//tr[td[2][normalize-space()='{0}']]");

    public static final Target BTN_DELETE =
            Target.the("Boton eliminar producto {0}")
                    .locatedBy("//tr[td[2][normalize-space()='{0}']]//a[text()='Delete']");

    public static final Target TOTAL_PRICE =
            Target.the("Precio total del carrito")
                    .located(By.id("totalp"));

    public static final Target BTN_PLACE_ORDER =
            Target.the("Boton realizar pedido")
                    .located(By.xpath("//button[text()='Place Order']"));
}
