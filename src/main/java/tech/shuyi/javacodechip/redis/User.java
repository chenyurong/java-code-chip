package tech.shuyi.javacodechip.redis;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ronald
 * @description
 * @date 2021/9/12
 */
@Data
public class User implements Serializable {
    private String name;
    private Integer age;
}
