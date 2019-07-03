import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Baidu {

    @Test
    public void testGetHtml(){
        given()
                .log().all().get("http://www.baidu.com")
                .then().log().all().statusCode(200);
    }

    @Test
    public void testMp3(){
        given()
                .queryParam("wd", "mp3")
        .when()
                .get("http://www.baidu.com/s")
        .then()
                .log().all()
                .statusCode(200);
    }
}
