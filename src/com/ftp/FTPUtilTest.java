package com.ftp;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

/**
 * @author acer
 * @date 2019/4/10
 */
public class FTPUtilTest {
    public static void main(String[] args) {
        try {
            FTPClient ftpClient = FTPUtil.loginFTP("192.168.8.88", 21, "userName", "******");
            FTPUtil.downloadFileFromFTP(ftpClient, "/usr/local/test.txt", "/Users/123/Downloads/test.txt");
            FTPUtil.uploadFileToFTP(ftpClient, "/Users/123/Downloads/test2.txt", "/usr/local/test2.txt");
            ftpClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
