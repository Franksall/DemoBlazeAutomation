package org.example.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("https://www.demoblaze.com/")
public class HomePage extends PageObject {

    public static final Target CATEGORY_PHONES =
            Target.the("Categoria Phones")
                    .located(By.linkText("Phones"));

    public static final Target CATEGORY_LAPTOPS =
            Target.the("Categoria Laptops")
                    .located(By.linkText("Laptops"));

    public static final Target CATEGORY_MONITORS =
            Target.the("Categoria Monitors")
                    .located(By.linkText("Monitors"));

    public static final Target CATEGORY =
            Target.the("Categoria {0}")
                    .locatedBy("//a[@id='itemc' and normalize-space(.)='{0}']");

    public static final Target PRODUCT_LIST =
            Target.the("Lista de productos del catalogo")
                    .located(By.cssSelector("#tbodyid .card-title a"));

    public static final Target PRODUCT =
            Target.the("Producto {0}")
                    .locatedBy("//div[@id='tbodyid']//a[normalize-space(.)='{0}']");

    public static final Target BTN_NEXT =
            Target.the("Boton siguiente")
                    .located(By.id("next2"));

    public static final Target BTN_PREVIOUS =
            Target.the("Boton anterior")
                    .located(By.id("prev2"));
    public static final Target BTN_CART =
            Target.the("Boton carrito de compras")
                    .located(By.id("cartur"));
}
