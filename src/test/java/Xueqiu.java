import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.hasItem;
public class Xueqiu {

    @Test
    public void testSearch(){
        //信任https的任何证书
        useRelaxedHTTPSValidation();

        //given开头表示输入数据
        given().log().all()//.proxy("127.0.0.1", 8888) 设置代理
                //query请求
                .queryParam("code", "sogo")
                //头信息
                .header("Cookie", "aliyungf_tc=AQAAAMdhGTUf8QgAElvsc3grxnPSF5m3; xq_a_token=6793401481303b0b4078c00acf521f116693ab76; xq_a_token.sig=kn3AtIz_AxxI0iAzWFBkTMIOFfQ; xq_r_token=e5e64b239ced9de9b2e1d1b37182159946e08cf0; xq_r_token.sig=Qc9zNevVZNNCDpgFt-leV4WiA0E; _ga=GA1.2.718969568.1554960309; _gid=GA1.2.1210320271.1554960309; _gat=1; u=821554960309551; device_id=9482158d2d2471950017f150a0d1e794; Hm_lvt_1db88642e346389874251b5a1eded6e3=1554960309,1554960351; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1554960351")
        //表示触发条件
        .when()
                .get("https://xueqiu.com/stock/search.json")
        //对结果断言
        .then()
                .log().all()
                //状态码断言
                .statusCode(200)
                //字段断言
                .body("stocks.name", hasItem("搜狗"))
                .body("stocks.ind_name", hasItem("通讯业务"));

    }
}
