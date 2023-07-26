package Activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import jdk.jfr.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class Activity1 {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    int petId;

    @BeforeClass
    public void setUp() {
        //Request Specification
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .addHeader("Content-Type", "application/json")
                .build();

        //Response Specification
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("status", equalTo("alive"))
                .build();
    }

    @Test(priority = 1)
    public void postRequestTest() {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 77232);
        reqBody.put("name", "Riley");
        reqBody.put("status", "alive");

        //Send POST Request
        Response response = given().spec(requestSpec).body(reqBody).log().all().when().post();

        //Extract id from response
        petId = response.then().extract().path("id");
        System.out.println(petId);
        //Assertions
        response.then().spec(responseSpec).body("name", equalTo("Riley"));
    }

    @Test(priority = 2)
    public void getRequestTest() {
        given().spec(requestSpec).pathParam("petId", petId).log().all()
                .when().get("/{petId}")
                .then().spec(responseSpec).body("name", equalTo("Riley"));
    }

    @Test(priority = 3)
    public void deleteRequestTest() {
        given().spec(requestSpec).pathParam("petId", petId)
                .when().delete("/{petId}")
                .then()
                .statusCode(200).time(lessThanOrEqualTo(3000L))
                .body("message", equalTo("" + petId));
    }
}