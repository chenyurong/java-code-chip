package tech.shuyi.javacodechip.cycledepend;

import org.springframework.stereotype.Component;

/**
 * @author Ronald
 * @since 2021/4/25
 */
@Component
public class C {
    private A a;

//    private C(A a) {
//    }
}
