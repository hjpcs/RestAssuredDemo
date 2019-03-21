package wework.contact;

import contact.wework.contact.Member;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

    @Test
    void create(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("userid", "hjp_"+member.random);
        map.put("name", "hjp_"+member.random);
        map.put("alias", "hjp_"+member.random);
        map.put("department", Arrays.asList(1, 2));
        map.put("mobile", "151"+member.random.substring(0, 8));
        map.put("email", member.random.substring(0, 8) + "@qq.com");
        member.create(map).then().statusCode(200).body("errcode", equalTo(0));
    }
}
