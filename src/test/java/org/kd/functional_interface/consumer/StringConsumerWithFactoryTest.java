package org.kd.functional_interface.consumer;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.kd.ObjectsFactory;
import org.kd.Person;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.kd.functional_interface.consumer.StringConsumerWithFactory.concatConsumer;
import static org.kd.functional_interface.consumer.StringConsumerWithFactory.createToLowerCaseStringConsumer;
import static org.kd.functional_interface.consumer.StringConsumerWithFactory.createToUpperCaseStringConsumer;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringConsumerWithFactoryTest {

    private List<String> rulerNames;
    private ByteArrayOutputStream newSystemOutputByteArray;
    private PrintStream oldSystemOutput;

    @BeforeAll
    public void setUp(){
        this.newSystemOutputByteArray = new ByteArrayOutputStream();
        this.oldSystemOutput = System.out;
        System.setOut(new PrintStream(newSystemOutputByteArray));

        rulerNames = new ObjectsFactory()
                .createPolishRulers()
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    @ParameterizedTest
    @ValueSource(strings = {"leszko", "popiel", "piast kolodziej", "siemowit", "lestek",
            "siemomysl", "mieszko"})
    public void testLowerCasePeopleConsumer(String ruler) {

        var consumer = new StringConsumerWithFactory();
        consumer.consumePeople(rulerNames, createToLowerCaseStringConsumer());
        assertThat(this.newSystemOutputByteArray.toString(), CoreMatchers.containsString(ruler));
    }

    @ParameterizedTest
    @ValueSource(strings = {"LESZKO", "POPIEL\r\nPIAST KOLODZIEJ\r\nSIEMOWIT\r\nLESTEK",
            "SIEMOMYSL", "MIESZKO"})
    public void testUpperCasePeopleConsumer(String ruler) {

        var consumer = new StringConsumerWithFactory();
        consumer.consumePeople(rulerNames, createToUpperCaseStringConsumer());
        assertThat(this.newSystemOutputByteArray.toString(), CoreMatchers.containsString(ruler));
    }

    @Test
    public void testConcatenationConsumer(){
        var consumer = new StringConsumerWithFactory();
        consumer.consumePeopleList(rulerNames, concatConsumer());
        assertThat(this.newSystemOutputByteArray.toString(), CoreMatchers.containsString("LestekSiemomyslMieszko"));
    }

    @AfterAll
    public void restoreSystemOut(){
        System.setOut(oldSystemOutput);
    }
}
