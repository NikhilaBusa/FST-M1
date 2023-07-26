package Activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class Activity2 {
    final static String req_URI = "https://petstore.swagger.io/v2/user";

    @Test(priority = 1)
    public void postTest() throws IOException
    {
        FileInputStream file = new FileInputStream("../src/test/resources/input.json");
        String reqBody = new String(file.readAllBytes());
        Response res = given().contentType(ContentType.JSON)
                .body(reqBody)
                .when().post(req_URI);
        file.close();
        System.out.println(res.getBody().asPrettyString());
        res.then().body("code", equalTo(200));
        res.then().body("message",equalTo("9999"));
    }

    @Test(priority = 2)
    public void getTest()
    {
        File outputJSON = new File("/src/test/resources/output.json");
        Response res = given().contentType(ContentType.JSON)
                .pathParam("username", "kafkatam")
                .when().get(req_URI + "/{username}");
        String resBody = res.getBody().asPrettyString();
        System.out.println(res.getBody().asPrettyString());
        try{
            outputJSON.createNewFile();
            FileWriter writer = new FileWriter(outputJSON.getPath());
            writer.write(resBody);
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        res.then().body("id",equalTo(9999));
        res.then().body("username",equalTo("kafkatam"));
        res.then().body("firstName",equalTo("Kafka"));
        res.then().body("lastName",equalTo("Tamura"));
        res.then().body("email",equalTo("kafkashore@mail.com"));
        res.then().body("password",equalTo("password123"));
        res.then().body("phone",equalTo("9812763450"));
    }

    @Test(priority = 3)
    public void deleteTest()
    {
        Response res = given().contentType(ContentType.JSON)
                .pathParam("username", "kafkatam")
                .when().delete(req_URI + "/{username}");
        System.out.println(res.getBody().asPrettyString());
        res.then().body("code",equalTo(200));
        res.then().body("message",equalTo("kafkatam"));
    }


}
