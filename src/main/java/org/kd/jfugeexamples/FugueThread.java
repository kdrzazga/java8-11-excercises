package org.kd.jfugeexamples;

public class FugueThread {

    public static void main(String[] args) {
        Fugue1 f1 = new Fugue1();

        Typing t1 = new Typing();
        t1.run();
        f1.run();

    }
}
