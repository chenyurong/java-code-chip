package tech.shuyi.javacodechip.acp;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.EvictionConfig;
import org.apache.commons.pool2.impl.EvictionPolicy;
import org.springframework.stereotype.Component;

/**
 * @author Ronald
 * @since 2021/5/9
 */
@Slf4j
@Component
public class SftpEvictionPolicy implements EvictionPolicy<com.jcraft.jsch.ChannelSftp> {
    @Override
    public boolean evict(EvictionConfig config, PooledObject<com.jcraft.jsch.ChannelSftp> underTest, int idleCount) {
        try {
            // 连接失效时进行驱逐
            if (!underTest.getObject().isConnected()) {
                log.warn("connect time out, evict the connection. time={}",System.currentTimeMillis() - underTest.getLastReturnTime());
                return true;
            }
        }catch (Exception e){
            return true;
        }
        return false;
    }
}
