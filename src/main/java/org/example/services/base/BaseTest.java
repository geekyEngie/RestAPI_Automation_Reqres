package org.example.services.base;
import io.restassured.RestAssured;
import org.example.services.configuration.Configuration;
import org.example.services.pages.ServicePages;
import org.example.services.filters.LoggingFilter;


public class BaseTest {

    public static ServicePages servicePages = new ServicePages();
    public void setUp(){
        RestAssured.baseURI = Configuration.getBaseURI();
        servicePages = new ServicePages();
        RestAssured.filters(new LoggingFilter());
        System.out.println("SetUp Completed");
    }
    public void tearDown(){
        System.out.println("Teardown Completed");
    }
}
