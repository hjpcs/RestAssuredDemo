package MacroIndicators;

import contact.wework.MacroIndicators.GetCurrencyMotilityShibor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class GetCurrencyMotilityShiborTest {

    GetCurrencyMotilityShibor getCurrencyMotilityShibor;
    @BeforeEach
    void setUp(){
        if (getCurrencyMotilityShibor == null){
            getCurrencyMotilityShibor = new GetCurrencyMotilityShibor();
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/timePeriod.csv")
    void getData(int timePeriod){
        String startDate = getCurrencyMotilityShibor.threeMonthAgoDate();
        String endTime = getCurrencyMotilityShibor.getCurrentDate();
        getCurrencyMotilityShibor.getData(startDate, endTime, timePeriod).then().statusCode(200)
                .body("data.shibor.data_amount", not(equalTo(null)));
    }
}
