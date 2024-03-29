package org.kd.test.functional_interface;

import org.testng.annotations.Test;
import org.kd.functional_interface.custom.FileProcessor;

import java.io.IOException;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class FileProcessorTest {

    @Test
    public void testReadingFile() {
        try {
            assertTrue(new FileProcessor(System.getProperty("user.dir")  +"/src/test/resources/testText.txt")
                    .process()
                    .startsWith("Bogurodzica"));

        } catch (IOException e) {
            fail("I/O error");
            e.printStackTrace();
        }
    }
}
