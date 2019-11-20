package org.kd.functional_interface.custom;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@AllArgsConstructor
public class FileProcessor implements BufferedReaderProcessor {

    private String fileName;

    @Override
    public String process() throws IOException {
        try (var bf = new BufferedReader(new FileReader(fileName))){
            return bf.readLine();
        }
    }
}
