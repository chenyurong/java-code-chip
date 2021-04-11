package tech.shuyi.javacodechip.acp;

import com.jcraft.jsch.ChannelSftp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SftpConnectPool {

    // 声明一个对象池
    private GenericObjectPool<ChannelSftp> sftpConnectPool;

    // 初始化参数
    public SftpConnectPool() {
        GenericObjectPoolConfig conf = new GenericObjectPoolConfig();
        conf.setMaxTotal(10);
        conf.setMaxIdle(5);
        sftpConnectPool = new GenericObjectPool<ChannelSftp>(new SftpConnectFactory(), conf);
    }

    public ChannelSftp borrowObject() {
        try {
            return sftpConnectPool.borrowObject();
        } catch (Exception e) {
            log.error("borrowObject error", e);
            return null;
        }
    }

    public void returnObject(ChannelSftp channelSftp) {
        if (channelSftp!=null) {
            sftpConnectPool.returnObject(channelSftp);
        }
    }
}