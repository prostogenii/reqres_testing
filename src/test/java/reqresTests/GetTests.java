package reqresTests;

import config.ReqresEndpoints;
import config.ReqresTestConfig;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetTests extends ReqresTestConfig {

    @Test
    public void getSingleUserTest(){
        given()
                .pathParam("userId", 2)
                .when()
                .get(ReqresEndpoints.SINGLE_USER)
                .then()
                .body("email", equalTo("janet.weaver@reqres.in"));
    }

    @Test
    public void getUsersTest(){
        given()
                .when()
                .get("users?page=2")
                .then();
    }

    @Test
    public void getHeaderFromUserOne(){
        Response response = given()
                .pathParam("userId", 1)
                .get(ReqresEndpoints.SINGLE_USER)
                .then()
                .extract().response();

        String contentType = response.getContentType();
        System.out.println(contentType);

    }

}
