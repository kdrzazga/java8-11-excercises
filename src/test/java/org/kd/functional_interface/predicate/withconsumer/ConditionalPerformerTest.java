package org.kd.functional_interface.predicate.withconsumer;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.kd.ObjectsFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConditionalPerformerTest {

    private ByteArrayOutputStream newSystemOutputByteArray;
    private PrintStream oldSystemOutput;

    @BeforeAll
    public void setUp() {
        this.newSystemOutputByteArray = new ByteArrayOutputStream();
        this.oldSystemOutput = System.out;
        System.setOut(new PrintStream(newSystemOutputByteArray));
    }

    @Test
    public void testWritingToOutput() {
        var rulersWithNamesOnSWriter = new ConditionalPerformer();

        rulersWithNamesOnSWriter.performConditionally(new ObjectsFactory().createPolishRulers()
                , ruler -> ruler.getName().startsWith("S")
                , (x) -> {
                    System.out.println(x.getName());
                });
        assertThat(this.newSystemOutputByteArray.toString(), CoreMatchers.containsString("Siemowit"));
        assertThat(this.newSystemOutputByteArray.toString(), CoreMatchers.containsString("Siemomysl"));
        assertThat(this.newSystemOutputByteArray.toString(), not(CoreMatchers.containsString("Mieszko")));
    }

    @AfterAll
    public void restoreSystemOut() {
        System.setOut(oldSystemOutput);
    }
}
