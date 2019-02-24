package org.kd.functional_interface.custom;

import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {

    String process() throws IOException;
}
