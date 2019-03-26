package wework.contact;

import contact.wework.contact.Member;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;

public class MemberTest {

    static Member member;
    //String random = String.valueOf(System.currentTimeMillis());
    @BeforeAll
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

    @ParameterizedTest
    @ValueSource(strings = {"hjp_", "zp_", "love_"})
    void create(String name){
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
}
