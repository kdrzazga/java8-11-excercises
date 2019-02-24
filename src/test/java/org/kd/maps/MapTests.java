package org.kd.maps;


import org.junit.Test;

import java.util.IdentityHashMap;
import java.util.LinkedHashMap;

public class MapTests {

    @Test
    public void test() {
        var m = new IdentityHashMap<Integer, String>();
        m.put(1, "jeden");
        m.put(2, "dwa");
        m.put(3, "trzy");

        m.keySet().forEach(System.out::println);
        m.values().forEach(System.out::println);

        m.entrySet().forEach( System.out::println);

    }

    @Test
    public void test2(){
        var m = new LinkedHashMap<Integer, String>();
        m.put(1, "jeden");
        m.put(2, "dwa");
        m.put(3, "trzy");

        m.keySet().forEach(System.out::println);
        m.values().forEach(System.out::println);

        m.entrySet().forEach( System.out::println);
    }
}
