package contact.wework.MacroIndicators;

import contact.wework.Restful;
import io.restassured.http.ContentType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class MacroIndicators extends Restful {

    public MacroIndicators(){
        reset();
    }

    public void reset(){
        requestSpecification = given()
                .log().all().contentType(ContentType.JSON);
    }

    //获取当天日期
    public String getCurrentDate(){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(date);
    }

    //获取当天日期的前三个月日期
    public String threeMonthAgoDate(){
        String currentDate = getCurrentDate();
        long currentDateLong = Long.valueOf(currentDate);
        long threeMonthAgoDateLong = currentDateLong - 300;
        String threeMonthAgoDate = String.valueOf(threeMonthAgoDateLong);
        return threeMonthAgoDate;
    }

    //获取当天日期的前一年日期
    public String oneYearAgoDate(){
        String currentDate = getCurrentDate();
        long currentDateLong = Long.valueOf(currentDate);
        long oneYearAgoDateLong = currentDateLong - 10000;
        String oneYearAgoDate = String.valueOf(oneYearAgoDateLong);
        return oneYearAgoDate;
    }

    //获取前一月，前三月，前半年，前一年日期
    /*public String getBeforeDate(int id){
        String currentDate = getCurrentDate();
        long currentDateLong = Long.valueOf(currentDate);
        long beforeDateLong;
        switch (id){
            case 1:
                beforeDateLong = currentDateLong - 100;
                break;
            case 2:
                beforeDateLong = currentDateLong - 300;
                break;
            case 3:
                beforeDateLong = currentDateLong;
        }


    }*/
    /*public static void main(String[] args){
        MacroIndicators macroIndicators = new MacroIndicators();
        System.out.println(macroIndicators.threeMonthAgoDate());
    }*/
}
