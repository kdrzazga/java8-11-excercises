package org.kd.function;

import lombok.Getter;

import java.util.Map;
import java.util.function.Supplier;

public class ModeToCodeMapsFactory {

    @Getter
    int a = 4;

    public Map<Modes, Runnable> createMappingToRunnable() {
        return Map.of(
                Modes.CONTROL, () -> System.out.println("Control mode"));
    }

    public Map<Modes, Supplier> createMappingToSupplier() {
        return Map.of(
                Modes.CONTROL, () -> {
                    System.out.println("Control");
                    a++;
                    return 4;
                }
        );
    }
}
