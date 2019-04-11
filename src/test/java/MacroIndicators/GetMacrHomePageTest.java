package MacroIndicators;

import contact.wework.MacroIndicators.GetMacrHomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class GetMacrHomePageTest {

    GetMacrHomePage getMacrHomePage;
    @BeforeEach
    void setUp(){
        if (getMacrHomePage == null){
            getMacrHomePage = new GetMacrHomePage();
        }
    }

    @Test
    void getData(){
        String date = getMacrHomePage.getCurrentDate();
        getMacrHomePage.getData(date).then().statusCode(200)
                .body("data.marketSentimentHomePage.marginTrade", not(equalTo(null)))
                .body("data.categoriesOfAssetsHomePage.rmbExchangeRate.data_amount", not(equalTo(null)))
                .body("data.categoriesOfAssetsHomePage.comexGold.data_amount", not(equalTo(null)))
                .body("data.currencyMotilityHomePage.m0", not(equalTo(null)))
                .body("data.currencyMotilityHomePage.m1", not(equalTo(null)))
                .body("data.currencyMotilityHomePage.m2", not(equalTo(null)))
                .body("data.currencyMotilityHomePage.save", not(equalTo(null)))
                .body("data.currencyMotilityHomePage.loan", not(equalTo(null)))
                .body("data.currencyMotilityHomePage.shibor", not(equalTo(null)))
                .body("data.priceIndexHomePage.pmi.data_amount", not(equalTo(null)))
                .body("data.priceIndexHomePage.cpi.data_amount", not(equalTo(null)))
                .body("data.priceIndexHomePage.ppi.data_amount", not(equalTo(null)))
                .body("data.nationalEconomyHomePage.gdp", not(equalTo(null)))
                .body("data.nationalEconomyHomePage.export_import", not(equalTo(null)));
    }


}
