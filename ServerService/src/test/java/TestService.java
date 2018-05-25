import com.miyou.ServiceApp;
import com.miyou.framework.ProcessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class TestService {

    @Autowired
    ProcessService processService;

    @Test
    public void get() throws Exception {
        Map<String,String> multiValueMap = new HashMap<>();
        multiValueMap.put("username","lake");//传值，但要在url上配置相应的参数

    }
}
