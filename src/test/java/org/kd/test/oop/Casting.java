package org.kd.test.oop;


import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import static org.testng.Assert.*;

public class Casting {

    @Test
    public void testCasting() {
        Integer original = 3;
        Object object = original;
        assertEquals(3, ((Integer) object).intValue());
    }

    @Test(groups = {"unit"})
    public void testDeepClone() {
        var original = new Vector<Integer>();
        original.add(1);

        var copy = (Vector) deepClone(original);
        assertEquals(1, copy.get(0));
        assertEquals(original, copy);
        assertNotSame(original, copy);

        original = null;
        assertNotNull(copy);

    }

    /**
     * This method makes a "deep clone" of any Java object it is given.
     *
     * @author Alvin Alexander, http://alvinalexander.com
     */
    public static Object deepClone(Object object) {
        try {
            var baos = new ByteArrayOutputStream();
            var oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            var bais = new ByteArrayInputStream(baos.toByteArray());
            var ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
