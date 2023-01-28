package reqresTests;

import config.ReqresTestConfig;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;

public class GpathJSONTests extends ReqresTestConfig {

    String ulr = "users?page=2";

    @Test
    public void takeOneUserUserFromList(){
        Response response = get(ulr);

        Map<String, ?> oneUserFromList = response.path("data.find{ it.first_name=='Lindsay'}");

        System.out.println("User has been found = "+oneUserFromList);

    }

    @Test
    public void assertTheUserNameTest(){
        Response response = get(ulr);

        String user = response.path("data.find{ it.first_name=='Byron'}.last_name");

        String lastUserName = "Fields";

        Assert.assertEquals(user,lastUserName);

        System.out.println("Information: "+user);
    }

    @Test
    public void getAllNamesFrom8IdTo10Id(){
      Response response = get(ulr);

        List<String> usersFrom8To10 = response.path("data.findAll{it.id>=8}.first_name");

        System.out.println(usersFrom8To10);
    }
}
