package stepDefinations.api.reqres;

import POJOClassess.DataPayload;
import com.util.APIUtil;
import com.util.DateUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;


import static io.restassured.RestAssured.given;

public class UserValidation {
    private static RequestSpecification requestSpecification;
//    private static ResponseSpecification responseSpecification;
    private Response response;
    private JsonPath jsonPath;
    private DataPayload dataPayload;
    private static String payload;
    private int userId;

    @Given("User have Base URL ready for execution")
    public void userHaveBaseURLReadyForExecution() throws FileNotFoundException {
        requestSpecification=APIUtil.requestBuilder();
        dataPayload=new DataPayload();
    }

    @Given("Trigger ListUser API request")
    public void triggerListUserAPIRequest() {
        response = given().spec(requestSpecification).get("/api/users");
        jsonPath=APIUtil.setJsonPath(response.getBody().asString());
    }
@Test
public void test(){
    System.out.println("test");
}
    @When("API returns {string} response")
    public void listUserAPIReturnsResponse(String responseCode) {
        Assert.assertEquals(Integer.parseInt(responseCode), response.getStatusCode());
    }

    @Then("Check whether per page user count is same as mentioned in the response")
    public void checkWhetherUserCountIsSameAsMentionedInTheResponse() {
        int givenPerPageUsers=jsonPath.getInt("per_page");
        int actualPerPageUsers=jsonPath.getInt("data.size()");
        Assert.assertEquals(actualPerPageUsers, givenPerPageUsers);
    }

    @Then("Check whether total users count is same as mentioned in the response")
    public void checkWhetherTotalUsersCountIsSameAsMentionedInTheResponse() {
        int expectedUserCount=jsonPath.getInt("total");
        int actualUserCount=0;
        for (int i=1;i<=jsonPath.getInt("total_pages");i++){
            String res=given().spec(requestSpecification).
                    queryParam("page",i).get("/api/user").
                    then().statusCode(200).extract().response().body().asString();
            JsonPath jsonPath1=APIUtil.setJsonPath(res);
            actualUserCount=actualUserCount+jsonPath1.getInt("data.size()");
        }
        Assert.assertEquals(expectedUserCount,actualUserCount);
    }

    @Given("Trigger ListUser API request with user id {string}")
    public void triggerListUserAPIRequestWithUserId(String userId) {
    response=given().spec(requestSpecification).get("/api/users/"+Integer.parseInt(userId));
    jsonPath=APIUtil.setJsonPath(response.getBody().asString());
    this.userId=Integer.parseInt(userId);
    }

    @Then("Check whether total pages count is same as mentioned in the response")
    public void checkWhetherTotalPagesCountIsSameAsMentionedInTheResponse() {
        int expectedPageCount=jsonPath.getInt("total_pages");
        int actualPageCount=0;
        for (int i=1;i<=jsonPath.getInt("total_pages")+1;i++){
            String res=given().spec(requestSpecification).
                    queryParam("page",i).get("/api/user").
                    then().statusCode(200).extract().response().body().asString();
            JsonPath jsonPath1=APIUtil.setJsonPath(res);
            if (jsonPath1.getInt("data.size()")>0){
                actualPageCount++;
            }
        }
        Assert.assertEquals(expectedPageCount,actualPageCount);
    }

    @Then("User details should be returned in the response")
    public void userDetailsShouldBeReturnedInTheResponse() {
        Assert.assertEquals(5,jsonPath.getInt("data.size()"));
        Assert.assertEquals(userId,jsonPath.getInt("data.id"));
        Assert.assertEquals(2,jsonPath.getInt("support.size()"));
        Assert.assertEquals(2,jsonPath.getInt("size()"));
    }

    @Then("User details should not be returned in the response")
    public void userDetailsShouldNotBeReturnedInTheResponse() {
        Assert.assertEquals(0,jsonPath.getInt("size()"));
    }

    @Given("User creates request payload with details {string} and {string}")
    public void userCreatesRequestPayloadWithDetailsAnd(String uname, String job) {
        payload=dataPayload.crudUserPayload(uname,job);
    }

    @And("Trigger CreateUser API request")
    public void triggerCreateUserAPIRequest() {
        response=given().spec(requestSpecification).contentType(ContentType.JSON).body(payload).when().post("/api/users").then().extract().response();
        jsonPath=APIUtil.setJsonPath(response.getBody().asString());
    }

    @Then("User should be created successfully")
    public void userShouldBeCreatedSuccessfully() {
        Assert.assertEquals(4,jsonPath.getInt("size()"));
    }
  @Then("{int} mentioned detail should be updated successfully")
    public void userShouldBeUpdatedSuccessfully(int expectedCount) {
        Assert.assertEquals(expectedCount+1,jsonPath.getInt("size()"));
    }

    @And("Validate user name as {string} and job details as {string} in api response")
    public void validateUserNameAsAndJobDetailsAsInApiResponse(String name, String job) {
        Assert.assertEquals(name,jsonPath.get("name"));
        Assert.assertEquals(job,jsonPath.get("job"));
    }

    @And("Validate if user creation date is today's")
    public void validateIfUserCreationDateIsTodayS() {
        String actualDate=jsonPath.get("createdAt");
        actualDate=actualDate.split("T")[0];
        Assert.assertEquals(DateUtil.getTodayDate("yyyy-MM-dd"),actualDate);
    }
    @And("Validate if user updating date is today's")
    public void validateIfUserUpdatingDateIsTodayS() {
        String actualDate=jsonPath.get("updatedAt");
        actualDate=actualDate.split("T")[0];
        Assert.assertEquals(DateUtil.getTodayDate("yyyy-MM-dd"),actualDate);
    }

    @And("Trigger UpdateUser API request with user id as {string}")
    public void triggerUpdateUserAPIRequestWithUserIdAs(String userID) {
        response=given().spec(requestSpecification).contentType(ContentType.JSON).body(payload).when().put("/api/users/"+userID).then().extract().response();
        jsonPath=APIUtil.setJsonPath(response.getBody().asString());
        userId=Integer.parseInt(userID);
    }

    @Given("User creates request payload with user name as {string}")
    public void userCreatesRequestPayloadWithUserNameAs(String uname) {
        payload=dataPayload.crudUserPayload(uname,null);
    }

    @And("Validate user name as {string} in api response")
    public void validateUserNameAsInApiResponse(String uname) {
        Assert.assertEquals(uname,jsonPath.get("name"));
    }  @And("Validate user job as {string} in api response")
    public void validateUserJobAsInApiResponse(String uname) {
        Assert.assertEquals(uname,jsonPath.get("job"));
    }

    @Given("User creates request payload with job title as {string}")
    public void userCreatesRequestPayloadWithJobTitleAs(String job) {
        payload=dataPayload.crudUserPayload(null,job);
    }

    @When("Trigger DeleteUser API request for user id {string}")
    public void triggerDeleteUserAPIRequestForUserId(String userID) {
        response=given().spec(requestSpecification).delete("/api/user/"+userID).then().extract().response();
    }

    @And("Trigger UpdateUser API request to update specific detail for user id as {string}")
    public void triggerUpdateUserAPIRequestToUpdateSpecificDetailForUserIdAs(String userID) {
        response=given().spec(requestSpecification).contentType(ContentType.JSON).body(payload).when().patch("/api/users/"+Integer.parseInt(userID)).then().extract().response();
        jsonPath=APIUtil.setJsonPath(response.getBody().asString());
        this.userId=Integer.parseInt(userID);
    }
}
