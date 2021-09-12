package tech.shuyi.javacodechip.cycledepend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Ronald
 * @since 2021/4/25
 */
@Component
public class A {

    @Autowired
    private B b;

//    private A(B b) {
//    }
}
