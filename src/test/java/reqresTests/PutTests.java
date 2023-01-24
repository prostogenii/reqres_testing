package reqresTests;

import config.ReqresEndpoints;
import config.ReqresTestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PutTests extends ReqresTestConfig {

    @Test
    public void upDateUser(){
        String newUser = "{\n" +
                "    \"name\": \"Sasha\",\n" +
                "    \"job\": \"none\"\n" +
                "}";
        given()
                .pathParam("userId", 5)
                .body(newUser)
                .when()
                .put(ReqresEndpoints.SINGLE_USER)
                .then()
                .statusCode(200);

    }
}
