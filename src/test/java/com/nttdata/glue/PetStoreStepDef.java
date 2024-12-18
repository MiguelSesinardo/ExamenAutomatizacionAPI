package com.nttdata.glue;

import com.nttdata.steps.PetStoreStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PetStoreStepDef {

    @Steps
    PetStoreStep tienda;

    @Given("la url es {string}")
    public void laUrlEs(String url) {
        tienda.urlBase(url);

    }

    @When("creo el orden de compra con {int}, {int}, {int} y {string}")
    public void creoElOrdenDeCompraConY(int idCompra, int idMascota, int cantidad,String estado) {
        tienda.realizarOrden(idCompra,idMascota,cantidad,estado);

    }


    @Then("valido el codigo de respuesta sea {int}")
    public void validoElCodigoDeRespuesaSeaCodigoRespuesta(int codigoRespuesta) {
        tienda.validacionCodigoRespuesta(codigoRespuesta);
    }

    @And("valida que el id de la compra sea {int}")
    public void validaQueElElIdDeLaCompraSeaIdCompra(int idCompra) {
        tienda.validarIdCompra(idCompra);
    }


    @When("consulto el numero de orden con {int}")
    public void consultoElNumeroDeOrdenConIdCompra(int idCompra) {
        tienda.consultarOrden(idCompra);
    }


    @And("valida que el petId sea {int}")
    public void validaQueElPetIdSeaIdMascota(int idMascota) {
        tienda.validarPetId(idMascota);
    }

    @And("valida que el campo cantidad sea {int}")
    public void validaQueElCampoCantidadSeaCantidad(int cantidad) {
        tienda.validarCantidad(cantidad);
    }

    @And("valida que el campo estado sea {string}")
    public void validaQueElCampoEstadoSeaStatus(String estado) {
        tienda.validarEstado(estado);
    }

    @And("valida que el campo complete sea verdadero")
    public void validaQueElCampoCompleteSea() {
        tienda.validarComplete();
    }
}
