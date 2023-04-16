package org.kd.test.function;

import org.kd.function.ModeToCodeMapsFactory;
import org.kd.function.Modes;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertTrue;
public class MappingEnumToCodeTest {

    private PrintStream oldSystemOutput;
    private ByteArrayOutputStream interceptedOutput;

    @BeforeMethod
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
        System.out.println("a=" + map.getA());

        assertTrue(interceptedOutput.toString().contains("Control"));
        assertTrue(interceptedOutput.toString().contains("a=5"));
    }

    @AfterMethod
    public void restoreSystemOutput() {
        System.setOut(oldSystemOutput);
    }
}
