package org.example.services.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static String baseURI;
    private static String single_endpoint;
    private static String list_endpoint;
    private static String post_endpoint;

    static {
       try(FileInputStream fis = new FileInputStream("config.properties")){
           Properties properties = new Properties();
           properties.load(fis);
           baseURI = properties.getProperty("baseURI");
           single_endpoint = properties.getProperty("single_endpoint");
           list_endpoint = properties.getProperty("list_endpoint");
           post_endpoint = properties.getProperty("post_endpoint");
       } catch (IOException e){
           e.printStackTrace();
       }
    }
    public static String getBaseURI(){
        return baseURI;
    }
    public static String getSingle_endpoint(){
        return single_endpoint;
    }
    public static String getList_endpoint(){
        return list_endpoint;
    }
    public static String getPost_endpoint(){
        return post_endpoint;
    }
}
