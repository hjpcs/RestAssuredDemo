package contact.wework.MacroIndicators;

import io.restassured.response.Response;

public class GetCurrencyMotilityShibor extends MacroIndicators{

    public Response getData(String startDate, String endTime, int timePeriod){
        reset();
        return requestSpecification.when()
                .queryParam("start_date", startDate)
                .queryParam("end_time", endTime)
                .queryParam("time_period", timePeriod)
                .post("http://10.253.102.208:9008/tools/get_currency_motility_shibor")
                .then().log().all().extract().response();
    }
}
