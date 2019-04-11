package MacroIndicators;

import contact.wework.MacroIndicators.GetMacroIndicatorsScore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class GetMacroIndicatorsScoreTest {

    GetMacroIndicatorsScore getMacroIndicatorsScore;
    @BeforeEach
    void setUp(){
        if (getMacroIndicatorsScore == null){
            getMacroIndicatorsScore = new GetMacroIndicatorsScore();
        }
    }

    @Test
    void getScore(){
        getMacroIndicatorsScore.getScore().then().statusCode(200)
                .body("data.scrq_score", not(equalTo(null)))
                .body("data.dlzc_score", not(equalTo(null)))
                .body("data.hbdn_score", not(equalTo(null)))
                .body("data.wjzs_score", not(equalTo(null)))
                .body("data.gmjj_score", not(equalTo(null)));
    }
}
