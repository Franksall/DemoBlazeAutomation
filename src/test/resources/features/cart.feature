@Cart @Regression
Feature: Gestion del carrito de compras

  Background:
    Given el usuario esta en la pagina de inicio

  @CP007 @HappyPath @Smoke
  Scenario: Agregar un producto al carrito
    When el usuario selecciona el producto "Samsung galaxy s6"
    And el usuario agrega el producto al carrito
    And el usuario accede al carrito de compras
    Then el usuario visualiza el producto "Samsung galaxy s6" en el carrito
    And el usuario verifica que el total del carrito sea 360 dolares

  @CP008 @HappyPath
  Scenario: Eliminar un producto del carrito
    When el usuario selecciona el producto "Nokia lumia 1520"
    And el usuario agrega el producto al carrito
    And el usuario accede al carrito de compras
    And el usuario elimina el producto "Nokia lumia 1520" del carrito
    Then el usuario verifica que el carrito este vacio

  @CP009 @HappyPath
  Scenario: Validar el precio total de varios productos
    When el usuario selecciona el producto "Samsung galaxy s6"
    And el usuario agrega el producto al carrito
    And el usuario regresa a la pagina de inicio
    And el usuario selecciona el producto "Nokia lumia 1520"
    And el usuario agrega el producto al carrito
    And el usuario accede al carrito de compras
    Then el usuario visualiza el producto "Samsung galaxy s6" en el carrito
    And el usuario visualiza el producto "Nokia lumia 1520" en el carrito
    And el usuario verifica que el total del carrito sea 1180 dolares
