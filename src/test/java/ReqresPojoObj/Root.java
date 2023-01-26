package ReqresPojoObj;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Root {
    public DataResponse data;
    public Support support;
}
