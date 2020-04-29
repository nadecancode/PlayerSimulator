package me.allen.playersimulator.tps;

import java.util.LinkedList;

public class TPSCheck
        implements Runnable {
    public LinkedList<Long> history = new LinkedList<>();
    private long last = System.currentTimeMillis();

    public void run() {
        long now = System.currentTimeMillis();
        long duration = now - this.last;
        if (duration < 1000L) {
            duration = 1000L;
        }
        this.history.add(duration);
        if (this.history.size() > 10) {
            this.history.poll();
        }
        this.last = now;
    }
}