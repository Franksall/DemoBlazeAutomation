@Checkout @Regression
Feature: Gestion del proceso de compra

  Background:
    Given el usuario esta en la pagina de inicio
    When el usuario selecciona el producto "Samsung galaxy s6"
    And el usuario agrega el producto al carrito
    And el usuario accede al carrito de compras

  @CP010 @HappyPath @Smoke
  Scenario: Realizar una compra exitosa
    When el usuario abre el formulario de compra
    And el usuario completa el formulario con los datos "Juan Perez", "Peru", "Arequipa", "4111111111111111", "12", "2028"
    And el usuario confirma la compra
    Then el usuario visualiza el mensaje de compra exitosa

  @CP011 @NegativePath
  Scenario Outline: Intentar comprar sin completar campos obligatorios
    When el usuario abre el formulario de compra
    And el usuario completa el formulario con los datos "<nombre>", "Peru", "Arequipa", "<tarjeta>", "12", "2028"
    And el usuario confirma la compra
    Then el usuario visualiza una alerta con el mensaje "Please fill out Name and Creditcard."

    Examples:
      | nombre     | tarjeta          |
      |            | 4111111111111111 |
      | Juan Perez |                  |
      |            |                  |

  @CP012 @HappyPath
  Scenario: Validar el importe de la confirmacion de compra
    When el usuario regresa a la pagina de inicio
    And el usuario selecciona el producto "Nokia lumia 1520"
    And el usuario agrega el producto al carrito
    And el usuario accede al carrito de compras
    Then el usuario verifica que el total del carrito sea 1180 dolares
    When el usuario abre el formulario de compra
    And el usuario completa el formulario con los datos "Juan Perez", "Peru", "Arequipa", "4111111111111111", "12", "2028"
    And el usuario confirma la compra
    Then el usuario visualiza el mensaje de compra exitosa
    And el usuario verifica que el importe de la compra sea 1180 dolares
