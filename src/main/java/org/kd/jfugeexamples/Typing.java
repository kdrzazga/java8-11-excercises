package org.kd.jfugeexamples;

import java.util.Random;

class Typing implements Runnable {

    public void run() {
        Random rand;

        short cnt = 128;

        while (cnt > 0) {
            rand = new Random(System.currentTimeMillis() % 255 + 100);
            try {
                System.out.print((char) rand.nextInt());
                Thread.sleep(30);
                cnt--;

            } catch (InterruptedException iexc) {
                System.err.println(iexc.getMessage());
            }
        }
    }
}