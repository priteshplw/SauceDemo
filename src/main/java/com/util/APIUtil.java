package com.util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class APIUtil {
    static File file;
    static {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        sdf.setCalendar(Calendar.getInstance(TimeZone.getTimeZone("GMT")));
         file=new File(System.getProperty("user.dir")+"/target/APILogs_"+sdf.format(System.currentTimeMillis())+".txt");
        System.out.println(file.getAbsolutePath());
    }

    public static RequestSpecification requestBuilder() throws FileNotFoundException {


        return new RequestSpecBuilder().setBaseUri("https://reqres.in/")
                .addFilter(RequestLoggingFilter.logRequestTo(new PrintStream(file.getAbsolutePath())))
                .build();
    }
    public static ResponseSpecification responseBuilderWithStatus(int statusCode) {
        return new ResponseSpecBuilder().expectStatusCode(statusCode).build();
    }
    public static JsonPath setJsonPath(String path){
        return new JsonPath(path);
    }
}
