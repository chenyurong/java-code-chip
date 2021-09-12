package tech.shuyi.javacodechip.cycledepend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Ronald
 * @since 2021/4/25
 */
@Component
public class C {

    @Autowired
    private A a;

//    private C(A a) {
//    }
}
