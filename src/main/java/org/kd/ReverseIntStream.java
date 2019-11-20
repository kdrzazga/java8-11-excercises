package org.kd;
import java.util.stream.IntStream;

public class ReverseIntStream {

    public static void main(String[] args) {
        int size = 7;
        IntStream.range(0, size - 1)
                .map(i -> size - 1 - i)
                .forEach(System.out::println);
    }

}
