package contact.wework.contact;

import contact.wework.Restful;
import contact.wework.Wework;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class Contact extends Restful {
    public Contact(){
        reset();
    }

    public void reset(){
        requestSpecification =  given()
                .log().all()
                .queryParam("access_token", Wework.getToken())
                .contentType(ContentType.JSON);

    }
}
