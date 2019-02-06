package org.kd.functional_interface;

import java.util.function.UnaryOperator;


public interface ChurchNumeral {

    <T> T apply(UnaryOperator<T> f, T arg);

    static ChurchNumeral valueOf(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument n must be non-negative.");
        }
        if (n == 0) {
            return (ChurchNumeralT<?>) (f, arg) -> arg;
        }
        return (ChurchNumeralT<?>) (f, arg) -> f.apply(valueOf(n - 1).apply(f, arg));
    }

    @FunctionalInterface
    interface ChurchNumeralT<T> extends ChurchNumeral {
        @SuppressWarnings({"rawtypes", "unchecked"})
        @Override
        default <U> U apply(UnaryOperator<U> f, U arg) {
            return (U) ((ChurchNumeralT) this).tapply(f, arg);
        }

        T tapply(UnaryOperator<T> f, T arg);
    }
}
