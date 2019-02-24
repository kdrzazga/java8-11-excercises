package org.kd.maps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnit4.class)
public class MapWithRunnablesTest {

    private PrintStream oldSystemOutput;
    private ByteArrayOutputStream interceptedOutput;
    private MapWithRunnables mapWithRunnables;

    @Before
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

    @After
    public void restoreSystemOut() {
        System.setOut(this.oldSystemOutput);
    }

}
