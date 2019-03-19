package wework.contact;

import contact.wework.contact.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class DepartmentTest {

    @BeforeEach
    void setUp(){

    }

    @Test
    void list(){
        Department department = new Department();
        department.list("").then().statusCode(200)
                .body("department.name[0]", equalTo("testhome74696"));

        department.list("44").then().statusCode(200)
                .body("department.name[0]", equalTo("testhome875"));
    }
}
