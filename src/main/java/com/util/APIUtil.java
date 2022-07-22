package com.util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class APIUtil {

    public static RequestSpecification requestBuilder() throws FileNotFoundException {
        return new RequestSpecBuilder().setBaseUri("https://reqres.in/")
                .addFilter(RequestLoggingFilter.logRequestTo(new PrintStream(System.getProperty("user.dir")+"/target/APILogs/APILogs.txt")))
                .build();
    }
    public static ResponseSpecification responseBuilderWithStatus(int statusCode) {
        return new ResponseSpecBuilder().expectStatusCode(statusCode).build();
    }
    public static JsonPath setJsonPath(String path){
        return new JsonPath(path);
    }
}
