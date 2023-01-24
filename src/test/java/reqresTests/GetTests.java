package reqresTests;

import config.ReqresEndpoints;
import config.ReqresTestConfig;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


import java.util.List;

import static io.restassured.RestAssured.get;
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
                .body("email", equalTo("janet.weaver@reqres.in"))
                .statusCode(200);
    }

    @Test
    public void getUsersTest(){
        given()
                .when()
                .get("users?page=2")
                .then()
                .statusCode(200);;
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

    @Test
    public void getAllNamesFromTheList(){
       Response response = get("users?page=2/data")
               .then()
               .extract().response();

        List<String> ollUsersNames = response.path("data.first_name");
        List<String> ollUserLastNames = response.path("data.last_name");

        for (int i=0; i<ollUsersNames.size(); i++){
            System.out.println(ollUsersNames.get(i)+" "+ollUserLastNames.get(i));
        }

    }

    @Test
    public void checkUserUsingJsonSchema(){
        given()
                .pathParam("userId", 3)
                .when()
                .accept("application/json")
                .get(ReqresEndpoints.SINGLE_USER)
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("ReqresJsonSchema.json"));
    }

}
