package contact.wework.MacroIndicators;

import io.restassured.response.Response;

public class GetMacrHomePage extends MacroIndicators{

    public Response getData(String date){
        reset();
        return requestSpecification.when()
                .queryParam("date_time", date)
                .post("http://10.253.102.208:9008/tools/get_macr_home_page")
                .then().log().all().extract().response();
    }
}
