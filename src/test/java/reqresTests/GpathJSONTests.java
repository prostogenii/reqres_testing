package reqresTests;

import config.ReqresEndpoints;
import config.ReqresTestConfig;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;

public class GpathJSONTests extends ReqresTestConfig {

    @Test
    public void takeOneUserUserFromList(){
        Response response = get(ReqresEndpoints.LIST_OF_USERS);

        Map<String, ?> oneUserFromList = response.path("data.find{ it.first_name=='Lindsay'}");

        System.out.println("User has been found = "+oneUserFromList);

    }

    @Test
    public void assertTheUserNameTest(){
        Response response = get(ReqresEndpoints.LIST_OF_USERS);

        String user = response.path("data.find{ it.first_name=='Byron'}.last_name");

        String lastUserName = "Fields";

        Assert.assertEquals(user,lastUserName);

        System.out.println("Information: "+user);
    }

    @Test
    public void getAllNamesFrom8IdTo10Id(){
      Response response = get(ReqresEndpoints.LIST_OF_USERS);

        List<String> usersFrom8To10 = response.path("data.findAll{it.id>=8}.first_name");

        System.out.println(usersFrom8To10);
    }

    @Test
    public void getUsersUsingArrayListAndMap(){

        String first_name = "Tobias";
        String last_name = "Edwards";

        Response response = get(ReqresEndpoints.LIST_OF_USERS);

       ArrayList<Map<String, ?>> users = response.path
               ("data.findAll{it.first_name=='%s'}", first_name);

        System.out.println(users);
    }
}
