package com.tta.tests.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tta.endpoints.APIConstants;
import com.tta.tests.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.requestSpecification;

public class CreateBooking  extends BaseTest {
    @Owner("Snehal Yadav")
    @Description("Verify Create Booking")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testCreateBooking() throws JsonProcessingException {

        // STEP 1 - make a req with payload
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured
                .given().spec(requestSpecification)
                .when().body(payLoadManager.createPayload())
                .post();

        // STEP 2 0 validate the response
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        // validate the response
        jsonPath = jsonPath.from(response.asString());
        System.out.println(jsonPath.getString("bookingid"));


    }
}
