import contact.wework.Wework;
import contact.wework.WeworkConfig;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class TestGetToken {

    @Test
    public void testToken(){
        Wework wework = new Wework();
        String token = wework.getWeworkToken(WeworkConfig.getInstance().secret);
        assertThat(token, not(equalTo(null)));
    }
}
