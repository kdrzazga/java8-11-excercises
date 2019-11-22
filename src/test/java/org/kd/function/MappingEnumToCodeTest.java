package org.kd.function;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

//@RunWith(JUnit4.class)
public class MappingEnumToCodeTest {

    private PrintStream oldSystemOutput;
    private ByteArrayOutputStream interceptedOutput;

    @BeforeEach
    public void setUp() {
        interceptedOutput = new ByteArrayOutputStream();
        oldSystemOutput = System.out;
        System.setOut(new PrintStream(interceptedOutput));
    }

    @Test
    public void testMappingEnumToCode() {
        new ModeToCodeMapsFactory().createMappingToRunnable().get(Modes.CONTROL).run();

        assertTrue(interceptedOutput.toString().contains("Control mode"));
    }

    @Test
    public void testMappingEnumToCode2() {
        var map = new ModeToCodeMapsFactory();
        System.out.println(map.createMappingToSupplier().get(Modes.CONTROL).get());
        System.out.println("a=" + map.a);

        assertTrue(interceptedOutput.toString().contains("Control"));
        assertTrue(interceptedOutput.toString().contains("a=5"));
    }

    @AfterEach
    public void restoreSystemOutput() {
        System.setOut(oldSystemOutput);
    }
}
