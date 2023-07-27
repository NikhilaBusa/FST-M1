package Activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class GitHub_RestAssured_Project {
    RequestSpecification reqSpec;
    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIPcnPNY3SbLvEA+ze/Gz86+vAnZXytlqZ6F0Z+oxcw1U";
    int id;

    @BeforeClass
    public void setUp()
    {
        reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://api.github.com")
                .build().header("Authorization", "Bearer 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");
    }

    @Test(priority = 1)
    public void postTest()
    {
        String reqBody = "{\"title\": \"TestNB\",\n" +
                "\"key\": \"" + sshKey + "\"}";
        Response res = given().spec(reqSpec).body(reqBody)
                .when().post("/user/keys");
        System.out.println(res.getBody().asPrettyString());
        id = res.then().extract().path("id");
        res.then().statusCode(201);
    }

    @Test(priority = 2)
    public void getTest()
    {
        Response response = given()
                .spec(reqSpec)
                .pathParam("keyId", id).log().all()
                .when()
                .get("/user/keys/{keyId}");
        response.getBody().prettyPrint();
        String report = response.getBody().asPrettyString();
        Reporter.log(report);
        response.then().statusCode(200);
    }

    @Test(priority = 3)
    public void delTest()
    {
        Response res = given().spec(reqSpec)
                .pathParam("keyId", id).log().all()
                .when().delete("/user/keys/{keyId}");
        System.out.println(res.getBody().asPrettyString());
        res.then().statusCode(204);
    }
}
