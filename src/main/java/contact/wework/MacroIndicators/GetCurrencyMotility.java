package contact.wework.MacroIndicators;

import io.restassured.response.Response;

public class GetCurrencyMotility extends MacroIndicators{

    public Response getData(String startDate, String endTime, int proPeriod){
        reset();
        return requestSpecification.when()
                .queryParam("start_date", startDate)
                .queryParam("end_time", endTime)
                .queryParam("pro_period", proPeriod)
                .post("http://10.253.102.208:9008/tools/get_currency_motility")
                .then().log().all().extract().response();
    }
}
