package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class FightQuertImpl extends Thread implements FightQuery {

    private String origin;
    private String destination;
    private List<String> flightList = new ArrayList<String>(10);

    public FightQuertImpl(String airLine, String origin, String destination) {
        super("[" + airLine + "]");
        this.origin = origin;
        this.destination = destination;
    }


    @Override
    public void run() {
        System.out.printf("%s-query from %s to %s \n", getName(), origin, destination);
        int randomVal = ThreadLocalRandom.current().nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(randomVal);
            this.flightList.add(getName() + "-" + randomVal);
            System.out.printf("The Fight:%s list query successful \n", getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        super.run();
    }

    @Override
    public List<String> getList() {
        return this.flightList;
    }
}
