package tech.shuyi.javacodechip.acp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SftpFileHelperTest {

    @Autowired
    private SftpFileHelper sftpFileHelper;

    @Test
    public void testDownloadFtpFile() throws Exception {
        sftpFileHelper.download("dir", "fileName", "fileName");
    }
}