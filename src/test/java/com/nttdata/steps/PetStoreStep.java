package com.nttdata.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import static org.hamcrest.MatcherAssert.assertThat;


public class PetStoreStep {


    Response response;
    private String urlBase;

    public void urlBase(String url) {

        urlBase = url;
    }


    public void realizarOrden(int idCompra, int idMascota, int cantidad, String estado) {

        String body = "{\n" +
                "  \"id\": " +String.valueOf(idCompra)+ " ,\n" +
                "  \"petId\": " +String.valueOf(idMascota)+ ",\n" +
                "  \"quantity\": "+ String.valueOf(cantidad) +",\n" +
                "  \"shipDate\": \"2024-12-17T20:35:00.387Z\",\n" +
                "  \"status\":\""+ estado+ "\",\n" +
                "  \"complete\": true\n" +
                "}";

        response = RestAssured
                .given()
                .baseUri(urlBase)
                .header("Content-Type","application/json")
                .body(body)
                .log().all()
                .post("/store/order")
                .then()
                .log().all()
                .extract().response();
    }

    public void validacionCodigoRespuesta(int codigoRespuesta) {
        Assert.assertEquals("Validacion de Respuesta", codigoRespuesta, response.statusCode());

    }

    public void validarIdCompra(int idCompra) {
        assertThat(response.body().path("id"), CoreMatchers.equalTo(idCompra));

    }

    public void consultarOrden(int idCompra) {
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri(urlBase)
                .log().all()
                .get("/store/order/"+ idCompra)
                .then()
                .log().all()
                .extract().response();

    }


    public void validarPetId(int idMascota) {
        assertThat(response.body().path("petId"), CoreMatchers.equalTo(idMascota));
    }

    public void validarCantidad(int cantidad) {
        assertThat(response.body().path("quantity"), CoreMatchers.equalTo(cantidad));
    }

    public void validarEstado(String estado) {
        assertThat(response.body().path("status"), CoreMatchers.equalTo(estado));
    }

    public void validarComplete() {
        Assert.assertTrue(response.body().path("complete"));
    }
}
