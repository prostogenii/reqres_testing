package reqresTests;

import config.ReqresEndpoints;
import config.ReqresTestConfig;
import objects.ReqresObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostTests extends ReqresTestConfig {

    @Test
    public void createUserTest(){
        String sergey = "{\n" +
                "    \"name\": \"Sergey\",\n" +
                "    \"job\": \"Game developer\"\n" +
                "}";
        given()
                .body(sergey)
                .when()
                .post(ReqresEndpoints.CREATE_USER)
                .then()
                .statusCode(201);

    }

    @Test
    public void logInAUser(){
        String user = "{\n" +
                "  \"username\": \"User123\",\n" +
                "  \"email\": \"em@gmail.com\",\n" +
                "  \"password\": \"qwert\"\n" +
                "}";
                given()
                        .body(user)
                        .when()
                        .post(ReqresEndpoints.LOG_IN_USER)
                        .then()
                        .statusCode(201);
    }

    @Test
    public void createUserUsingObjTest(){
        ReqresObject reqresObject = new ReqresObject("Misha", "builder");
        given()
                .body(reqresObject)
                .when()
                .post(ReqresEndpoints.CREATE_USER)
                .then()
                .statusCode(201);
    }
}
