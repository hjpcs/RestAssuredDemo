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
                .header("Cookie", "aliyungf_tc=AQAAALpvIGZJAwcAD1vsc4f9Kkg/i9oP; xq_a_token=8309c28a83ae5d20f26b7fcc22debbcd459794bd; xq_a_token.sig=ekfY9a_we8nNlhOpvhWeZz85MrU; xq_r_token=d55d09822791a788916028e59055668bed1b7018; xq_r_token.sig=h9qWLLwRXV-QxfHHukEC2U76ZDA; _ga=GA1.2.2041960590.1552388687; _gid=GA1.2.1284476650.1552388687; Hm_lvt_1db88642e346389874251b5a1eded6e3=1552388687; u=111552388688026; device_id=531aff57f94a41f382c40d671c28e049; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1552388693")
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
