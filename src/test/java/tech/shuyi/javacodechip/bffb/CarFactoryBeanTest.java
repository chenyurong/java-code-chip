package tech.shuyi.javacodechip.bffb;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Ronald
 * @since 2021/4/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CarFactoryBeanTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void getCarTest() throws Exception {
        Car car = (Car)applicationContext.getBean("carFactoryBean");
        System.out.println(car);
    }

    @Test
    public void getCarFactoryBeanTest() throws Exception {
        CarFactoryBean carFactoryBean = (CarFactoryBean)applicationContext.getBean("&carFactoryBean");
        System.out.println(carFactoryBean);
    }
}
