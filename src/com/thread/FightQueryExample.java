package com.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FightQueryExample {
    private static List<String> fightCompany = Arrays.asList("CSA", "CEA", "HNA");

    public static void main(String[] args) {
        List<String> results = search("SH", "BJ");
        System.out.println("====================result===================");
        results.forEach(System.out::println);

    }

    private static List<String> search(String origin, String destination) {
        final List<String> result = new ArrayList<String>(10);
        List<FightQuertImpl> fightQueryList = new ArrayList<FightQuertImpl>();
        for (String airLine : fightCompany) {
            fightQueryList.add(new FightQuertImpl(airLine, origin, destination));
        }
        //分别启动这几个线程
        for (FightQuertImpl thread : fightQueryList) {
            thread.start();
        }
        //分别调用每一个线程的join方法，阻塞当前线程
        for (FightQuertImpl fightQuert : fightQueryList) {
            try {
                fightQuert.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //在此之前，当前线程会阻塞住，获取每一个查询线程的结果，并且加入result中
        fightQueryList.stream().map(FightQuery::getList).forEach(result::addAll);

//        for (FightQuertImpl fightQuert : fightQueryList) {
//            List<String> list = fightQuert.getList();
//            result.addAll(list);
//        }

        return result;

    }

    private static FightQuertImpl createSearchTask(String airLine, String origin, String destination) {
        return new FightQuertImpl(airLine, origin, destination);
    }
}
