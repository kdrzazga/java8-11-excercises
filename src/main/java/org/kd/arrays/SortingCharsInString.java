package org.kd.arrays;

import java.util.Arrays;

public class SortingCharsInString {

    public String sortChars(String s) {
        var chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
