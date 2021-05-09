package tech.shuyi.javacodechip.cycledepend;

import org.springframework.stereotype.Component;

/**
 * @author Ronald
 * @since 2021/4/25
 */
@Component
public class A {
    private B b;

//    private A(B b) {
//    }
}
