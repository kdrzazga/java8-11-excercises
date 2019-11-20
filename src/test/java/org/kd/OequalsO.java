package org.kd;

public class OequalsO {

    public static void main(String[] args) {
        Object o = new Object();

        assert o.equals(o);
        assert o.hashCode() == o.hashCode();
    }
}
