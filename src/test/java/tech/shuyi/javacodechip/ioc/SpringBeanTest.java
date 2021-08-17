package tech.shuyi.javacodechip.ioc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Ronald
 * @since 2021/4/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringBeanTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void iocTest() throws Exception {
        applicationContext.getBean("apple");
    }
}