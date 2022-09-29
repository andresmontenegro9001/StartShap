Feature: Orden de compra
  Yo como usuario
  Necesito agregar una nueva orden al sistema
  Para validar el correcto funcionamiento del modulo

  Background: The user login StartShap
    Given that a StartShap user has access
    When  he submits username and password
    Then  he access and observes title "Dashboard"

  Scenario Outline: The user add new order
    Given Need add order
    When  fill data form general
      | customer   | orderDate   | requiredDate   | employee   |
      | <customer> | <orderDate> | <requiredDate> | <employee> |
    And fill order detail
      | product   | unitPrice   | quantity   | discount   |
      | <product> | <unitPrice> | <quantity> | <discount> |
    Then  see the register created
    Examples:
      | customer                    | orderDate  | requiredDate | employee        | product      | unitPrice | quantity | discount |
      | Antonio Moreno Taquería     | 09/28/2022 | 10/02/2022   | Steven Buchanan | Gula Malacca | 19.45     | 1        | 0.00     |
      | Gourmet Lanchonetes [GOURL] | 09/28/2022 | 10/02/2022   | Nancy Davolio   | Chai         | 18.00     | 1        | 0.00     |
      | LILA-Supermercado [LILAS]   | 09/28/2022 | 10/02/2022   | Robert King     | Ikura        | 31.00     | 1        | 0.00     |