package org.kd.functional_interface;

import org.junit.jupiter.api.Test;
import org.kd.functional_interface.custom.FileProcessor;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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
