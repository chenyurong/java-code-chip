package tech.shuyi.javacodechip.bffb;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ronald
 * @since 2021/4/25
 */
@Component
public class CarFactoryBean implements FactoryBean<Car> {
    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setBrand("BMW");
        car.setColor("red");
        car.setPrice("1000000");
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class.getClass();
    }
}
