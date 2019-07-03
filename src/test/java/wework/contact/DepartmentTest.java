package wework.contact;

import contact.wework.contact.Department;
import data.DataSource;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;

public class DepartmentTest {

    Department department;
    String random = String.valueOf(System.currentTimeMillis());
    @BeforeMethod
    void setUp(){
        if (department == null) {
            department = new Department();
            department.deleteAll();
        }
    }

    @Test
    void list(){
        department.list("").then().statusCode(200);
        //todo:id=13没起作用
        department.list("13").then().statusCode(200);
        /*department.list("").then().statusCode(200)
                .body("department.name[0]", equalTo("呓语中的"))
                .body("department.id[1]", equalTo(2))
                .body("department.parentid[2]", equalTo(1))
                .body("department.order[3]", equalTo(100000000));

        department.list("13").then().statusCode(200)
                .body("department.name[0]", equalTo("法务组"))
                .body("department.id[0]", equalTo(13));*/
    }

    @Test
    void create(){
        department.create("hjp"+random, "1")
                .then().body("errcode", equalTo(0));

    }

    @Test
    void createByMap(){
        HashMap<String, Object> map = new HashMap<String, Object>(){{
            put("name", "hjp_map"+random);
            put("parentid", "1");

        }};
        department.create(map).then().body("errcode", equalTo(0));
    }

    @Test
    void createWithChinese(){
        department.create("何金鹏"+random, "1")
                .then().body("errcode", equalTo(0));
    }

    @DataProvider
    public Object[][] dataProvider(Method method) {
        DataSource data = new DataSource();
        Object[][] obj = data.dataSource().get(method.getName());
        return obj;
    }

    @Test(dataProvider = "dataProvider")
    void createWithDup(String name, Integer expectCode){
        department.create(name + random, "1").then().body("errcode", equalTo(0));
        department.create(name + random, "1").then().body("errcode", equalTo(expectCode));
    }

    @Test
    void delete(){
        String oldName = "hjp"+random;
        department.create(oldName, "1");
        Integer idInt = department.list("")
                .path("department.find{it.name=='"+ oldName +"'}.id");
        System.out.println(idInt);
        String id = String.valueOf(idInt);
        department.delete(id).then().body("errcode", equalTo(0));
    }

    @Test
    void update(){
        String oldName = "hjp"+random;
        department.create(oldName, "1");
        Integer idInt = department.list("")
                .path("department.find{it.name=='"+ oldName +"'}.id");
        System.out.println(idInt);
        String id = String.valueOf(idInt);
        department.update("hjpa"+random, id).then().log().all().body("errcode", equalTo(0));
        department.delete(id).then().body("errcode", equalTo(0));
    }

    @Test
    void deleteAll(){
        department.deleteAll();
    }

    /*@Test
    void updateAll(){
        //todo:
        HashMap<String, Object> map = new HashMap<>();
        department.api("api.json", map).then().statusCode(200);
    }*/
}
