package org.kd.functional_interface.filter;

import java.util.stream.IntStream;

public class InterviewTask {

    public int[] findIndicesWithSum(int[] arr, String sum) {
        int sumValue;
        try {
            sumValue = Integer.valueOf(sum).intValue();
        } catch (NumberFormatException nfe) {
            System.err.println("Wrong number " + sum);
            return new int[0];
        }

        return IntStream.range(0, arr.length - 1)
                .filter(i -> arr[i] + arr[i + 1] == sumValue)
                .toArray();

    }
}
