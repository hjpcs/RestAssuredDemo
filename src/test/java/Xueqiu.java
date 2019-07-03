import org.testng.annotations.Test;

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
                .header("Cookie", "aliyungf_tc=AQAAAI0f7QOB3gkAD1vsc/k2+728NllT; s=br1awx45pc; xq_a_token=a372422d9868382896fce9d09a2dc00226e07c79; xq_r_token=274f931308c1541849da32315243b9f5bef6965d; u=111562133316694; Hm_lvt_1db88642e346389874251b5a1eded6e3=1562133317; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1562133317; device_id=4a0dfbe58f7cbf2576d61626a9aa01c1")
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
