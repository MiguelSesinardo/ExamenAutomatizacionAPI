@todo

Feature: PetStore API


  @crearOrden
  Scenario Outline: Agregar orden al Store
    Given la url es "https://petstore.swagger.io/v2"
    When creo el orden de compra con <idCompra>, <idMascota>, <cantidad> y "<status>"
    Then valido el codigo de respuesta sea <codigoRespuesta>
    And valida que el id de la compra sea <idCompra>
    And valida que el petId sea <idMascota>
    And valida que el campo cantidad sea <cantidad>
    And valida que el campo estado sea "<status>"
    And valida que el campo complete sea verdadero

    Examples:
      | idCompra | idMascota | cantidad | status   | codigoRespuesta |
      | 100      | 102       | 2        | approved | 200             |
      | 101      | 102       | 2        | approved | 200             |

  @consultarOrden

  Scenario Outline: Consultar Orden

    Given la url es "https://petstore.swagger.io/v2"
    When consulto el numero de orden con <idCompra>
    Then valido el codigo de respuesta sea <codigoRespuesta>
    And valida que el id de la compra sea <idCompra>
    And valida que el petId sea <idMascota>
    And valida que el campo cantidad sea <cantidad>
    And valida que el campo estado sea "<status>"
    And valida que el campo complete sea verdadero
    Examples:
      | idCompra | idMascota | cantidad | status   | codigoRespuesta |
      | 100      | 102       | 2        | approved | 200             |
      | 101      | 102       | 2        | approved | 200             |
