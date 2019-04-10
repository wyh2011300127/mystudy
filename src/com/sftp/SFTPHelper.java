package com.sftp;

import com.jcraft.jsch.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author acer
 * @date 2019/4/10
 */
public class SFTPHelper {
    //    private static Log log = LogFactory.getLog(SFTPHelper.class);
    private ChannelSftp sftp;

    /**
     * sftp服务器ip
     */
    protected String host;
    /**
     * 用户名
     */
    protected String username;
    /**
     * 密码
     */
    protected String password;
    /**
     * 密钥文件路径
     */
    protected String privateKey;
    /**
     * 密钥口令
     */
    protected String passphrase;
    /**
     * 默认的sftp端口号是22
     */
    protected int port = 22;

    /**
     * 构造类
     *
     * @param host
     * @param username
     * @param password
     * @param privateKey
     * @param passphrase
     */
    public SFTPHelper(String host, String username, String password, String privateKey, String passphrase) {
        connectServer(host, username, password, privateKey, passphrase);
    }

    /**
     * 获取连接
     *
     * @return channel
     */
    public void connectServer(String host, String username, String password, String privateKey, String passphrase) {
        JSch jsch = new JSch();
        Channel channel = null;
        try {
            if (privateKey != null && !"".equals(privateKey)) {
                // 使用密钥验证方式，密钥可以使有口令的密钥，也可以是没有口令的密钥
                if (passphrase != null && "".equals(passphrase)) {
                    jsch.addIdentity(privateKey, passphrase);
                } else {
                    jsch.addIdentity(privateKey);
                }
            }
            Session session = jsch.getSession(username, host, port);
            if (password != null && !"".equals(password)) {
                session.setPassword(password);
            }
            Properties sshConfig = new Properties();
            // do not verify host
            sshConfig.put("StrictHostKeyChecking", "no");
            // key
            session.setConfig(sshConfig);
            /**
             * <pre>
             * session.setTimeout(timeout);
             * </pre>
             */
            session.setServerAliveInterval(92000);

            session.connect();
            // 参数sftp指明要打开的连接是sftp连接
            channel = session.openChannel("sftp");
            channel.connect();
//            log.info("连接成功");
        } catch (JSchException e) {
//            log.info("连接失败==" + e);
        }
        this.sftp = (ChannelSftp) channel;
    }

    /**
     * 覆盖上传
     *
     * @param directory
     * @param uploadFile
     */
    public synchronized boolean uploadFile(String localFile, String remoteFile) throws Exception {

        // 是否是在根目录 下
        boolean flag = true;
        if (remoteFile.indexOf("/") != -1) {
            String path = remoteFile.substring(0, remoteFile.lastIndexOf("/")) + "/";
            mkdirs(path);
        }
        try {
            sftp.put(localFile, remoteFile, ChannelSftp.OVERWRITE);
        } catch (Exception e) {
            flag = false;
//            log.error(e);
        }
        return flag;
    }

    public boolean isDirectoryExists(String path) {
        boolean flag = true;
        try {
            sftp.cd(path);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 下载文件
     *
     * @param directory    下载目录
     * @param downloadFile 下载的文件
     * @param saveFile     存在本地的路径
     * @param sftp
     */
    public void download(String directory, String downloadFile, String saveFile) {
        try {
            sftp.cd(directory);
            sftp.get(downloadFile, saveFile);
        } catch (Exception e) {
//            log.error(e);
        }
    }

    /**
     * 删除文件
     *
     * @param directory  要删除文件所在目录
     * @param deleteFile 要删除的文件
     * @param sftp
     */
    public void delete(String directory, String deleteFile) {
        try {
            sftp.cd(directory);
            sftp.rm(deleteFile);
        } catch (Exception e) {
//            log.error(e);
        }
    }

    /**
     * 断开连接
     *
     * @param sftp
     */
    public void disconnect() {
        if (sftp != null) {
            try {
                sftp.getSession().disconnect();
            } catch (JSchException e) {
//                log.error(e);
            }
            sftp.disconnect();
        }
    }

    public String pwd() throws SftpException {
        return sftp.pwd();
    }

    public boolean cd(String path) {
        boolean flag = true;
        try {
            sftp.cd(path);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public boolean mkdir(String path) {
        boolean flag = true;
        try {
            sftp.mkdir(path);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public boolean mkdirs(String pathname) {
        // 注意编码，如果不编码文件中文目录无法创建
        StringBuilder tmp = new StringBuilder(pathname);
        List<String> dirList = new ArrayList<String>();
        // 目录不存在
        while (tmp.toString().contains("/") && !cd(tmp.toString())) {
            int pos = tmp.substring(0, tmp.length() - 1).lastIndexOf("/");
            String dir = "";
            dir = tmp.substring(pos + 1, tmp.length() - 1);
            dirList.add(dir);
            tmp.append(tmp.substring(0, pos) + "/");
        }
        if (!cd(tmp.toString())) {
            // 加入更新目录
            dirList.add(tmp.toString());
        }
        boolean success = true;
        for (int i = dirList.size() - 1; i >= 0; i--) {
            String dir = (String) dirList.get(i);
            success = mkdir(dir);
            success = cd(dir);
            if (!success) {
                break;
            }
        }
        return success;
    }

    public static void main(String[] args) {
        SFTPHelper helper = new SFTPHelper("10.243.30.72", "ahact", "ah@yh@act72", null, null);
        try {
//            log.info("sftp.pwd()==" + helper.pwd());
//            log.info("测试多目录新建开始");
            helper.mkdirs("/ahact/test/test2");
            helper.cd("/ahact/test/");
//            log.info("sftp.cd()==" + helper.pwd());
//            log.info("开始传输文件...");
            helper.uploadFile("/ahact/bea/applications/marketInterface.tar", "/ahact/test/我靠.tar");
//            log.info("结束传输文件...");
//            log.info("测试中文是否乱码...");
            helper.uploadFile("/ahact/bea/applications/marketInterface.tar", "/ahact/test/我靠.tar");
//            log.info("测试目的路径无路径,上传是否成功");
            helper.uploadFile("/ahact/bea/applications/marketInterface.tar", "/ahact/test/test/test/test123.tar");
            helper.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
//            log.error(e);
            helper.disconnect();
        }
        // helper.delete("/ftptester", "网页特效.rar", sftp);
    }
}
