package wework.contact;

import contact.wework.contact.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class DepartmentTest {

    Department department;
    @BeforeEach
    void setUp(){
        if (department == null) {
            department = new Department();
        }
    }

    @Test
    void list(){

        department.list("").then().statusCode(200)
                .body("department.name[0]", equalTo("呓语中的"))
                .body("department.id[1]", equalTo(2))
                .body("department.parentid[2]", equalTo(1))
                .body("department.order[3]", equalTo(100000000));

        department.list("13").then().statusCode(200)
                .body("department.name[0]", equalTo("法务组"))
                .body("department.id[0]", equalTo(13));
    }

    @Test
    void create(){
        department.create("hjp", "14");
    }
}
