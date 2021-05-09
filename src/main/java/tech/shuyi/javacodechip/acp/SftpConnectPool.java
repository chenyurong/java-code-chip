package tech.shuyi.javacodechip.acp;

import com.jcraft.jsch.ChannelSftp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

@Slf4j
public class SftpConnectPool {

    private GenericObjectPool<ChannelSftp> sftpConnectPool;

    public SftpConnectPool(SftpConnectFactory sftpConnectFactory) {
        // 设置连接池配置
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setEvictionPolicyClassName("tech.shuyi.javacodechip.acp.SftpEvictionPolicy");
        poolConfig.setBlockWhenExhausted(true);
        poolConfig.setJmxEnabled(false);
        poolConfig.setMaxWaitMillis(1000 * 10);
        poolConfig.setTimeBetweenEvictionRunsMillis(60 * 1000);
        poolConfig.setMinEvictableIdleTimeMillis(20 * 1000);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setMaxTotal(3);
        // 设置抛弃策略
        AbandonedConfig abandonedConfig = new AbandonedConfig();
        abandonedConfig.setRemoveAbandonedOnMaintenance(true);
        abandonedConfig.setRemoveAbandonedOnBorrow(true);
        this.sftpConnectPool = new GenericObjectPool<>(sftpConnectFactory, poolConfig, abandonedConfig);
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