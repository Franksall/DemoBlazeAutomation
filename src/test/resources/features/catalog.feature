@Catalog @Regression
Feature: Gestion del catalogo de productos

  Background:
    Given el usuario esta en la pagina de inicio

  @CP001 @HappyPath @Smoke
  Scenario: Visualizar el catalogo de productos
    Then el usuario visualiza las categorias disponibles
    And el usuario visualiza productos en el catalogo

  @CP002 @HappyPath
  Scenario Outline: Filtrar productos por categoria
    When el usuario selecciona la categoria "<categoria>"
    Then el usuario visualiza el producto "<producto>"

    Examples:
      | categoria | producto          |
      | Phones    | Samsung galaxy s6 |
      | Laptops   | Sony vaio i5      |
      | Monitors  | Apple monitor 24  |

  @CP003 @HappyPath
  Scenario: Navegar entre las paginas del catalogo
    When el usuario selecciona el boton siguiente
    Then el usuario visualiza una nueva pagina de productos
    When el usuario selecciona el boton anterior
    Then el usuario visualiza los productos de la pagina anterior