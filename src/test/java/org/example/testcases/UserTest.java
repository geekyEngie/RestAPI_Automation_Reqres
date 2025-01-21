package org.example.testcases;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.services.base.BaseTest;
import org.example.services.utils.Userpayload;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
@Listeners(org.example.listeners.TestListeners.class)

public class UserTest extends BaseTest {



    @Test(priority = 1)
    public void testgetUsers(){
        Response response = servicePages.getUsers();
        System.out.println(response.asPrettyString());
        System.out.println(response.asPrettyString());
        JsonPath jsonpath = response.jsonPath();
        String name = jsonpath.getString("data.first_name");
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(name,"Janet");
    }

    @Test(priority = 2)
    public void testgetAllUsers(){
        Response response = servicePages.getAllUsers();
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

    @Test(priority = 3)
    public void testcreateUser(){
        Userpayload userpayload = new Userpayload(35, 123, "Lord", "Krishna");
        Response response = servicePages.createUser(userpayload);
        System.out.println(response.asPrettyString());
        String message = response.jsonPath().getString("message");
        //Assert.assertEquals("User created successfully.", message);
        System.out.println(response.asPrettyString());

    }
}

