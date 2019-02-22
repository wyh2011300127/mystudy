package com.design.patterns.singleton;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * 枚举实现单个数据源
 *
 * @author:wangyuheng
 * @date:2019/1/25 16:40
 */
public enum DataSourceEnum {
    /**
     * 枚举实现单个数据源
     */
    DATASOURCE;

    private DBConnection dbConnection = null;

    /**
     * 初始化一个数据源实例
     */
    DataSourceEnum() {
        dbConnection = new DBConnection();
    }

    private DBConnection getDbConnection() {
        return dbConnection;
    }

    public static void main(String[] args) {
        Set<DBConnection> set = new HashSet<>();
        int threadCount = 100000;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    DBConnection dbConnection = DataSourceEnum.DATASOURCE.getDbConnection();
                    set.add(dbConnection);
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (DBConnection dbConnection : set) {
            System.out.println(dbConnection);
        }
        System.out.println("执行结束");
    }

}
