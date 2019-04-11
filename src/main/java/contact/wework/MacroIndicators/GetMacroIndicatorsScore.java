package contact.wework.MacroIndicators;

import io.restassured.response.Response;

public class GetMacroIndicatorsScore extends MacroIndicators{

    public Response getScore(){
        reset();
        return requestSpecification.when()
                .post("http://10.253.102.208:9008/tools/get_macro_indicators_score")
                .then().log().all().extract().response();
    }
}

