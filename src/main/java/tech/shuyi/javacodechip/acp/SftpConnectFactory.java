package tech.shuyi.javacodechip.acp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Slf4j
@Component
public class SftpConnectFactory extends BasePooledObjectFactory<ChannelSftp>{

    public static final String USER_NAME = "xxx";
    public static final String PASSWORD = "xxx";
    public static final String HOST = "xx.xx.com";
    public static final int PORT = 22;


    @Override
    public ChannelSftp create() throws Exception {
        ChannelSftp channel = null;
        try {
            JSch jsch = new JSch();
            Session sshSession = jsch.getSession(USER_NAME, HOST, PORT);
            sshSession.setPassword(PASSWORD);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            channel = (ChannelSftp) sshSession.openChannel("sftp");
            sshSession.setTimeout(60 * 1000);
            channel.connect();
        } catch (Exception e) {
            log.warn("SFTP连接异常", e);
        }
        return channel;
    }

    @Override
    public PooledObject<ChannelSftp> wrap(ChannelSftp channelSftp) {
        return new DefaultPooledObject<>(channelSftp);
    }

    @Override
    public void destroyObject(PooledObject<ChannelSftp> p) {
        ChannelSftp channelSftp = p.getObject();
        channelSftp.disconnect();
    }
}