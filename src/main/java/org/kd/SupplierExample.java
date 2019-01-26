package org.kd;

import java.util.Set;
import java.util.Vector;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierExample {

    public String printStream() {
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(s -> true);   // ok
        streamSupplier.get().noneMatch(s -> true);  // ok

        return streamSupplier.get().findAny()
                .orElse("error! ");
    }

    public static void main(String[] args) {
        System.out.println(new SupplierExample().printStream());

        Vector<String> s;
    }
}
