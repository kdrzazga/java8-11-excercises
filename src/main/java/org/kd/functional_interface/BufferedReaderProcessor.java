package org.kd.functional_interface;

import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {

    String process() throws IOException;
}
