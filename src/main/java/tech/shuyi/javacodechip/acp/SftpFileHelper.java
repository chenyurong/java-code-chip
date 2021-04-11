package tech.shuyi.javacodechip.acp;

import com.jcraft.jsch.ChannelSftp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@Component
public class SftpFileHelper {

    @Autowired
    private SftpConnectPool sftpConnectPool;

    public void download(String dir, String file, String saveUrl)throws IOException {
        ChannelSftp sftp = sftpConnectPool.borrowObject();
        log.info("begin to download file, dir={}, file={}, saveUrl={}", dir, file, saveUrl);
        try {
            if (!StringUtils.isEmpty(dir)) {
                sftp.cd(dir);
            }
            File downloadFile = new File(saveUrl);
            sftp.get(file, new FileOutputStream(downloadFile));
        }catch (Exception e){
            log.warn("下载文件失败", e);
        }finally {
            sftpConnectPool.returnObject(sftp);
        }
        log.info("file:{} is download successful", file);
    }
}