package wework.contact;

import contact.wework.contact.Member;
import data.DataSource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;

public class MemberTest {

    static Member member;
    //String random = String.valueOf(System.currentTimeMillis());
    @BeforeClass
    static void setUp(){
        if (member == null) {
            member = new Member();
        }
    }

    @Test
    void get(){
        member.get("dev1").then().log().all().statusCode(200);
        member.get("product1").then().log().all().statusCode(200);
        member.get("HeJinPeng").then().log().all().statusCode(200);
    }

    @DataProvider
    public Object[][] dataProvider(Method method) {
        DataSource data = new DataSource();
        Object[][] obj = data.dataSource().get(method.getName());
        return obj;
    }

    @Test(dataProvider = "dataProvider")
    void memberCreate(String name){
        String nameNew = name + member.random;
        String random = String.valueOf(System.currentTimeMillis()).substring(5+0, 5+8);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userid", nameNew);
        map.put("name", nameNew);
        map.put("alias", nameNew);
        map.put("department", Arrays.asList(1, 2));
        map.put("mobile", "151" + random);
        map.put("email", random + "@qq.com");
        member.create(map).then().statusCode(200).body("errcode", equalTo(0));
    }

    @Test(dataProvider = "dataProvider")
    void memberCreateWithAlias(String name, String alias){
        String nameNew = name + member.random;
        String random = String.valueOf(System.currentTimeMillis()).substring(5+0, 5+8);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userid", nameNew);
        map.put("name", nameNew);
        map.put("alias", alias);
        map.put("department", Arrays.asList(1, 2));
        map.put("mobile", "151" + random);
        map.put("email", random + "@qq.com");
        member.create(map).then().statusCode(200).body("errcode", equalTo(0));
    }
}
