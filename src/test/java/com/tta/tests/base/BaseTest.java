package com.tta.tests.base;
import com.tta.actions.AssertActions;
import com.tta.endpoints.APIConstants;
import com.tta.module.PayLoadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
public class BaseTest {

    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayLoadManager payLoadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;


    @BeforeMethod
    public void setupconfig(){

        payLoadManager = new PayLoadManager();
        assertActions = new AssertActions();

        requestSpecification = (RequestSpecification) new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type","application/json").build().log().all();

    }

    public String getToken(){

        requestSpecification = RestAssured.given().baseUri(APIConstants.BASE_URL).basePath("/auth");

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        response = requestSpecification.contentType(ContentType.JSON)
                .body(payload)
                .when().post();

        jsonPath = new JsonPath(response.asString());
        return  jsonPath.getString("token");

    }
    @BeforeMethod
    public void teardown(){
        System.out.println("END !! ");
    }

}