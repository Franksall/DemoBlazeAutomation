@Product @Regression
Feature: Consulta de detalles de productos

  Background:
    Given el usuario esta en la pagina de inicio

  @CP004 @HappyPath @Smoke
  Scenario: Acceder al detalle de un producto
    When el usuario selecciona el producto "Samsung galaxy s6"
    Then el usuario visualiza el detalle del producto "Samsung galaxy s6"

  @CP005 @HappyPath
  Scenario Outline: Validar el nombre y precio de diferentes productos
    When el usuario selecciona la categoria "<categoria>"
    And el usuario selecciona el producto "<producto>"
    Then el usuario visualiza el detalle del producto "<producto>"
    And el usuario verifica que el precio del producto sea <precio> dolares

    Examples:
      | categoria | producto          | precio |
      | Phones    | Samsung galaxy s6 | 360    |
      | Laptops   | Sony vaio i5      | 790    |
      | Monitors  | Apple monitor 24  | 400    |

  @CP006 @HappyPath
  Scenario: Validar los elementos del detalle de un producto
    When el usuario selecciona el producto "Nokia lumia 1520"
    Then el usuario visualiza la descripcion del producto
    And el usuario visualiza la imagen del producto
    And el usuario visualiza el boton agregar al carrito habilitado
