package org.example.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductPage {

    public static final Target PRODUCT_NAME =
            Target.the("Nombre del producto")
                    .located(By.cssSelector("#tbodyid h2.name"));

    public static final Target PRODUCT_PRICE =
            Target.the("Precio del producto")
                    .located(By.cssSelector("#tbodyid .price-container"));

    public static final Target PRODUCT_DESCRIPTION =
            Target.the("Descripcion del producto")
                    .located(By.cssSelector("#more-information p"));

    public static final Target PRODUCT_IMAGE =
            Target.the("Imagen del producto")
                    .located(By.cssSelector("#imgp img"));

    public static final Target BTN_ADD_TO_CART =
            Target.the("Boton agregar al carrito")
                    .located(By.xpath("//a[normalize-space()='Add to cart']"));
}
