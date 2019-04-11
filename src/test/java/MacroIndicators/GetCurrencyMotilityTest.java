package MacroIndicators;

import contact.wework.MacroIndicators.GetCurrencyMotility;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class GetCurrencyMotilityTest {

    GetCurrencyMotility getCurrencyMotility;
    @BeforeEach
    void setUp(){
        if (getCurrencyMotility == null){
            getCurrencyMotility = new GetCurrencyMotility();
        }
    }

    @Test
    void getData(){
        String startDate = getCurrencyMotility.oneYearAgoDate();
        String endTime = getCurrencyMotility.getCurrentDate();
        int proPeriod = 0;
        getCurrencyMotility.getData(startDate, endTime, proPeriod).then().statusCode(200)
                .body("data.m0.data_amount", not(equalTo(null)))
                .body("data.m1.data_amount", not(equalTo(null)))
                .body("data.m2.data_amount", not(equalTo(null)))
                .body("data.sz.data_amount", not(equalTo(null)));
        //todo:如何解析response里每个数据的个数
        Response response = getCurrencyMotility.getData(startDate, endTime, proPeriod);
        String res = response.asString();
        System.out.println(res);
    }
}
