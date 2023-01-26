package ReqresPojoObj;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse {

    public int id;
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;

}
