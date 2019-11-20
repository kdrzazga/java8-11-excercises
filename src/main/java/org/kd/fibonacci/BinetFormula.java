package org.kd.fibonacci;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class BinetFormula {


    public static long berechnenMitBinetFormula(int n) {
        double fi = (1 + sqrt(5)) / 2;
        return (long) ((pow(fi, n) - pow(1 - fi, n)) / sqrt(5));
    }

}
