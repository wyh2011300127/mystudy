package com.sftp;

/**
 * @author acer
 * @date 2019/4/10
 */
public class SftpHeplerDemo {
    public static void main(String[] args) {
        String ip = "192.168.1.110";
        SFTPHelper sftpHelper = new SFTPHelper(ip, "wangyuheng", "yhyyyy", null, null);
    }
}
