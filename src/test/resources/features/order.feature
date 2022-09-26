
 Feature: Orden de compra
   Yo como usuario
   Necesito agregar una nueva orden al sistema
   Para validar el correcto funcionamiento del modulo

   Background: The user login StartShap
     Given that a StartShap user has access
     When  he submits username and password
     Then  he access and observes title "Dashboard"

   Scenario: The user add new order
     Given Need add order
     When  fill data form
     Then  see the register



