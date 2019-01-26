package org.kd.functional_interface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor implements BufferedReaderProcessor {
    @Override
    public String process() throws IOException {
        try (var bf = new BufferedReader(new FileReader("testText.txt"))){
            return bf.readLine();
        }
    }
}
