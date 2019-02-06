package org.kd.function;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class MappingEnumToCodeTest {

    private PrintStream oldSystemOutput;
    private ByteArrayOutputStream interceptedOutput;

    @Before
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

    @After
    public void restoreSystemOutput() {
        System.setOut(oldSystemOutput);
    }
}
