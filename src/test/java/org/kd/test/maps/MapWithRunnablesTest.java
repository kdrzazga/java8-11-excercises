package org.kd.test.maps;


import org.kd.maps.MapWithRunnables;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MapWithRunnablesTest {

    private PrintStream oldSystemOutput;
    private ByteArrayOutputStream interceptedOutput;
    private MapWithRunnables mapWithRunnables;

    @BeforeMethod
    public void setUp() {
        mapWithRunnables = new MapWithRunnables();
        this.oldSystemOutput = System.out;
        interceptedOutput = new ByteArrayOutputStream();
        var ps = new PrintStream(interceptedOutput);
        System.setOut(ps);
    }

    @Test
    public void testGet0() {
        mapWithRunnables.getExecutiveMap().get(0).run();
        assertTrue(interceptedOutput.toString().contains("zero"));
    }

    @Test
    public void testGet1() {
        mapWithRunnables.getExecutiveMap().get(1).run();
        assertTrue(interceptedOutput.toString().contains("1"));
    }

    @Test
    public void testGet2() {
        mapWithRunnables.getExecutiveMap().get(2).run();
        assertEquals(2, mapWithRunnables.getA());
    }

    @Test
    public void testGet3() {
        mapWithRunnables.getExecutiveMap().get(3).run();
        assertTrue(interceptedOutput.toString().contains("-1"));
    }

    @AfterMethod
    public void restoreSystemOut() {
        System.setOut(this.oldSystemOutput);
    }

}
