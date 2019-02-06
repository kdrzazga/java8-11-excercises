package org.kd.functional_interface;

@FunctionalInterface
public interface CustomFunctionalInterface {

     void apply();

    // void a2(); - error, only 1 method allowed in functional Interface
}
