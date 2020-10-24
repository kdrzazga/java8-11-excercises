package org.kd.functional_interface.predicate.recruitment;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/*
Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of
the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three
and five print “FizzBuzz”.
* */
public class Ubs {

    private void printNumbers() {
        var div3 = new DivisibleBy3();
        var div5 = new DivisibleBy5();

        IntStream.range(1, 100).forEach(i -> {
                    if (div3.test(i)) System.out.print("Fizz");
                    if (div5.test(i)) System.out.print("Buzz");
                    if (!div3.test(i) && !div5.test(i)) System.out.print(i);
                    System.out.print(" ");
                }
        );
    }

    public static void main(String[] args) {
        new Ubs().printNumbers();
    }

    private class DivisibleBy3 implements IntPredicate {

        @Override
        public boolean test(int value) {
            return value % 3 == 0;
        }
    }

    private class DivisibleBy5 implements IntPredicate {

        @Override
        public boolean test(int value) {
            return value % 5 == 0;
        }
    }
}
