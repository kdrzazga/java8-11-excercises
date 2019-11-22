package org.kd;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

public class SumArrays {
    /*
    uzupełnij implementację metody sumArrays, tak, aby zwróciła sumę wartości z obu tablic. Dopisz odpowiednie testy (nie ma konieczności użycia junit).
     */

    public static void main(String[] args) {
        var correctSum = new SumArrays().sumArrays(new int[]{10, 20}, new int[]{5, 10});
        var wrongSum = new SumArrays().sumArrays(new int[]{10, 20, 30}, new int[]{5, 10});

        correctSum.ifPresent(s -> System.out.println("Sum is " + s));
        wrongSum.ifPresent(s -> System.out.println("Sum is " + s));
    }

    public Optional<Double> sumArrays(int[] a, int[] b) {
        if (a.length != b.length)
            return Optional.empty();

        IntSummaryStatistics statsA = Arrays.stream(a).boxed().collect(Collectors.summarizingInt(Integer::intValue));
        IntSummaryStatistics statsB = Arrays.stream(b).boxed().collect(Collectors.summarizingInt(Integer::intValue));
        return Optional.of((double) (statsA.getSum() + statsB.getSum()));
    }

}
