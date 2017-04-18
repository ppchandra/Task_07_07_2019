import com.alibaba.fastjson.JSON;
import com.itclj.bean.UserBean;
import com.itclj.config.RestTemplateConfiguration;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lujun.chen on 2017/4/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestClientTest.class)
@Import({RestTemplateConfiguration.class})
public class RestClientTest {

  private Logger logger = LoggerFactory.getLogger(RestClientTest.class);

  @Resource
  private RestTemplate restTemplate;

  /**
   * 模拟RestTemp 客户端调用
   *
   * 以实体对象直接向服务端传参数的时候服务端需加上@RequestBody注解
   */
  @Test
  public void restClient() {
    UserBean userBean = new UserBean();
    userBean.setName("王五");
    String result = restTemplate
        .postForObject("http://127.0.0.1:8280/user/add", userBean, String.class);
    logger.info("result:{}", result);
  }

  /**
   * MultiValueMap传参
   *
   * 这种方式服务端是接受得到参数的
   */
  @Test
  public void multiValueMapParam() {
    MultiValueMap<String, String> requestParam = new LinkedMultiValueMap<>();
    requestParam.set("name", "张三");
    UserBean result = restTemplate
        .postForObject("http://127.0.0.1:8280/user/add", requestParam, UserBean.class);
    logger.info("result:{}", JSON.toJSON(result));
  }

}
