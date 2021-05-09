package tech.shuyi.javacodechip.acp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ronald
 * @since 2021/5/9
 */
@Configuration
public class SftpConfig {

    /**
     * 初始化连接工厂
     * @return
     */
    @Bean
    public SftpConnectFactory sftpConnectFactory() {
        return new SftpConnectFactory();
    }

    /**
     * 初始化连接池
     * @param factory
     * @return
     */
    @Bean
    public SftpConnectPool sftpConnectPool(SftpConnectFactory factory) {
        return new SftpConnectPool(factory);
    }

    /**
     * 初始化文件辅助类
     * @param pool
     * @return
     */
    @Bean
    public SftpFileHelper sftpFileHelper(SftpConnectPool pool) {
        return new SftpFileHelper(pool);
    }
}
