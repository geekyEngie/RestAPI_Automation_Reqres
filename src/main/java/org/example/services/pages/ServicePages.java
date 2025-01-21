package org.example.services.pages;

import io.restassured.response.Response;
import org.example.services.configuration.Configuration;
import org.example.services.utils.Userpayload;

import static io.restassured.RestAssured.*;

public class ServicePages {
    public Response getUsers(){
        return  given()
                .baseUri(Configuration.getBaseURI())
                .header("Content-TYpe","application/json")
                .when()
                .get(Configuration.getSingle_endpoint())
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
    }

    public Response getAllUsers(){
        return given()
                .baseUri(Configuration.getBaseURI())
                .header("Content-TYpe", "application/json")
                .when()
                .get(Configuration.getList_endpoint())
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
    }

    public Response createUser(Userpayload userpayload){
        return given()
                .baseUri(Configuration.getBaseURI())
                .header("Content-Type", "application/json")
                .when()
                .post(Configuration.getPost_endpoint())
                .then()
                .statusCode(201)
                .log().all()
                .extract().response();


    }
}
