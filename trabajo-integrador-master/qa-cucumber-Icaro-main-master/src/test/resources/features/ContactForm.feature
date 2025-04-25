@testRegresion
Feature: formulario contacto

  Scenario Outline: El usuario completa el formulario de contacto y lo completa correctamente
    Given el usuario se encuentra en la home de la pagina
    When el usuario hace clic en el enlace de contacto
    And el usuario ingres Full Name "<name>"
    And el usuario ingres Email "<email>"
    And el usuario ingres phone number "<phone>"
    And el usuario ingres un message "<message>"
    And el usuario apreta el boton de submit
    Then elusuariovisualizamensajeElenvíodelformulariofueexitoso!

    Examples:
      | name    | email              | phone   | message                     |
      | Juan Pérez | juan.perez@email.com | 1234567890 | Este es un mensaje de prueba |
      | Ana López  | ana.lopez@otro.com | 9876543210 | Otro mensaje para probar    |