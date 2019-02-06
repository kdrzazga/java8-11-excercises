package org.kd.function;

import java.util.Map;
import java.util.function.Supplier;

class ModeToCodeMapsFactory {

    int a = 4;

    Map<Modes, Runnable> createMappingToRunnable() {
        return Map.of(
                Modes.CONTROL, () -> {
                    System.out.println("Control mode");
                });
    }

    Map<Modes, Supplier> createMappingToSupplier() {
        return Map.of(
                Modes.CONTROL, () -> {
                    System.out.println("Control");
                    a++;
                    return 4;
                }
        );



    }


}
