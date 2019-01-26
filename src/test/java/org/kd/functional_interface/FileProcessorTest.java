package org.kd.functional_interface;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class FileProcessorTest {

    @Test
    public void testReadingFile() {
        var fileProcessor = new FileProcessor();

        try {
            assertTrue(fileProcessor.process().startsWith("Bogurodzica"));
        } catch (IOException e) {
            fail("I/O error");
            e.printStackTrace();
        }
    }
}
