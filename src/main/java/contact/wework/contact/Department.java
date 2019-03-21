package contact.wework.contact;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;

public class Department extends Contact {

    public Response list(String id){
        Response response = requestSpecification
                .param("id", id)
        .when().get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
        .then().extract().response();
        reset();
        return response;
    }

    public Response create(String name, String parentid){
        reset();
        String body = JsonPath.parse(this.getClass()
                .getResourceAsStream("/data/create.json"))
                .set("$.name", name)
                .set("parentid", parentid).jsonString();

        return requestSpecification
                .body(body)
        .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
        .then().extract().response();
    }

    public Response create(HashMap<String, Object> map){
        reset();
        DocumentContext documentContext = JsonPath.parse(this.getClass()
                .getResourceAsStream("/data/create.json"));
        map.entrySet().forEach(entry->{
            documentContext.set(entry.getKey(), entry.getValue());
        });
        return requestSpecification
                .body(documentContext.jsonString())
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().extract().response();
    }

    public Response delete(String id){
        reset();
        return requestSpecification
                .queryParam("id", id)
        .when().get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
        .then().extract().response();
    }

    public Response update(String name, String id){
        reset();
        String body = JsonPath.parse(this.getClass()
                .getResourceAsStream("/data/update.json"))
                .set("$.name", name)
                .set("id", id).jsonString();

        return requestSpecification
                .body(body)
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/update")
                .then().extract().response();
    }
}
