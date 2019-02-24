package org.kd.maps;

import java.util.Map;

public class MapWithRunnables {

    private int a = -1;

    private Map<Integer, Runnable> executiveMap = Map.of(
            0, () -> {
                System.out.println("zero");
            },

            1, () -> System.out.println(1),

            2, () -> {
                a = 2;
            },

            3, () -> {
                a = 3;
                var mapWithRunnables = new MapWithRunnables();
                System.out.println(mapWithRunnables.a);
            },

            4, () -> {
                a = 4;
                new MapWithRunnables().getExecutiveMap().get(2).run();
                System.out.println(a);
            }
    );

    public Map<Integer, Runnable> getExecutiveMap() {
        return executiveMap;
    }

    public int getA() {
        return a;
    }
}
