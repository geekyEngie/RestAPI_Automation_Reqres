package org.example.services;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;



import static io.restassured.RestAssured.*;

public class test {


    @BeforeClass
    public void setUp(){
        baseURI = "https://reqres.in/";
    }

    /*@Test*/
    public void GetUsers() {
        Response response = given()
                .baseUri(baseURI)
                .header("Content-Type", "application/json")
                .when()
                .get("/api/users?page=2")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<String> ActualName = jsonPath.getList("data.first_name");
        List<String>expectedUsers = List.of("Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel");
        List<String> last_name = jsonPath.getList("data.last_name");
        List<String>expectedLast_name = List.of("Lawson", "Ferguson" , "Funke", "Fields", "Edwards", "Howell");
        List<String> Actualavatar = jsonPath.getList("data.avatar");
        List<String> ExpectedAvatar = List.of(
                "https://reqres.in/img/faces/7-image.jpg",
                "https://reqres.in/img/faces/8-image.jpg",
                "https://reqres.in/img/faces/9-image.jpg",
                "https://reqres.in/img/faces/10-image.jpg",
                "https://reqres.in/img/faces/11-image.jpg",
                "https://reqres.in/img/faces/12-image.jpg"
        );

        List<Integer>ids = jsonPath.get("data.id");
        List<Integer>expectedIds = List.of(7,8,9,10,11,12);

        System.out.println("This is complete response" + response.prettyPrint());
        Assert.assertEquals(ActualName, expectedUsers);
        Assert.assertEquals(last_name, expectedLast_name);
        Assert.assertEquals(Actualavatar, ExpectedAvatar);
        for (int id : ids){
            Assert.assertTrue(id>=7 && id<=12, "Invalid ID" + id);
        }
        System.out.println("All IDs are unique and within the range ");

    }
    @Test
    public void getAllUsers(){
        Response response = given()
                .baseUri(baseURI)
                .header("Content-Type", "application/json")
                .when()
                .get("/api/users?page=2")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
        System.out.println(response.prettyPrint());
    }
}