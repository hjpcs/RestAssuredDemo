package contact.wework;

public class WeworkConfig {

    public String agentId="1000002";
    public String secret="SeVKA2FS1xhMi-Jp-MMcinlD1iUZb_ucK1UeknelefI";
    public String corpid="wwd0f5cc0224c77f7d";
    public String contactSecret="gjK120EL_7LOVbazAuc70cmwU4krR-PV-fb5wqR58ss";

    //懒汉单例模式
    private static WeworkConfig weworkConfig = null;
    public static WeworkConfig getInstance(){
        if (weworkConfig == null)
            weworkConfig = new WeworkConfig();
        return weworkConfig;
    }

    public static void load(String path){
        //todo:read from yaml or json
    }
}
