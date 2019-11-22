package org.kd.jfugeexamples;

public class FugueThread {

    public static void main(String[] args) {
        var f1 = new Fugue1();

        var t1 = new Typing();
        t1.run();
        f1.run();

    }
}
