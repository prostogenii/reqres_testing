package reqresTests;

import config.ReqresEndpoints;
import config.ReqresTestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteTests extends ReqresTestConfig {

    @Test
    public void deleteUser(){
        given()
                .pathParam("userId", 6)
                .when()
                .delete(ReqresEndpoints.SINGLE_USER)
                .then()
                .statusCode(204);;
    }
}
