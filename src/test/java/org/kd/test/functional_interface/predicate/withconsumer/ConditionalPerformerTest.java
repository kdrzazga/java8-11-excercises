package org.kd.test.functional_interface.predicate.withconsumer;

import org.hamcrest.CoreMatchers;
import org.kd.functional_interface.predicate.withconsumer.ConditionalPerformer;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.kd.ObjectsFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConditionalPerformerTest {

    private ByteArrayOutputStream newSystemOutputByteArray;
    private PrintStream oldSystemOutput;

    @BeforeSuite
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
                , (x) -> System.out.println(x.getName()));
        assertThat(this.newSystemOutputByteArray.toString(), CoreMatchers.containsString("Siemowit"));
        assertThat(this.newSystemOutputByteArray.toString(), CoreMatchers.containsString("Siemomysl"));
        assertThat(this.newSystemOutputByteArray.toString(), not(CoreMatchers.containsString("Mieszko")));
    }

    @AfterSuite
    public void restoreSystemOut() {
        System.setOut(oldSystemOutput);
    }
}
