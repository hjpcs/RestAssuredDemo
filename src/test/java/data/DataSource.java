package data;

import java.util.HashMap;
import java.util.Map;

public class DataSource {

    /**
     * dataMap里有两个数据源，分别是memberCreate，memberCreateWithAlias
     * 根据测试方法的名称，来使用不同的数据源
     * 比如memberCreate就用数据源memberCreate
     * memberCreateWithAlias就用数据源memberCreateWithAlias
     * @return
     */
    public Map<String, Object[][]> dataSource() {
        Map<String, Object[][]> dataMap = new HashMap<String, Object[][]>();
        Object[][] memberCreate = new Object[][]{
                {"hjp_"},
                {"zp_"},
                {"love_"}
        };
        dataMap.put("memberCreate", memberCreate);
        Object[][] memberCreateWithAlias = new Object[][]{
                {"a1_", "hjp_alias_"},
                {"a2_", "zp_alias_"},
                {"a3_", "love_alias_"}
        };
        dataMap.put("memberCreateWithAlias", memberCreateWithAlias);
        Object[][] createWithDup = new Object[][]{
                {"dump1_", 60008},
                {"dump2_", 60008},
                {"dump3_", 60008}
        };
        dataMap.put("createWithDup", createWithDup);
        return dataMap;
    }
}
