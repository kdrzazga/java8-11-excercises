package org.kd.functional_interface.consumer;

import org.hamcrest.CoreMatchers;
import org.kd.ObjectsFactory;
import org.kd.Person;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.kd.functional_interface.consumer.StringConsumerWithFactory.*;

public class StringConsumerWithFactoryTest {

    private List<String> rulerNames;
    private ByteArrayOutputStream newSystemOutputByteArray;
    private PrintStream oldSystemOutput;

    @BeforeSuite
    public void setUp() {
        this.newSystemOutputByteArray = new ByteArrayOutputStream();
        this.oldSystemOutput = System.out;
        System.setOut(new PrintStream(newSystemOutputByteArray));

        rulerNames = new ObjectsFactory()
                .createPolishRulers()
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    @DataProvider(name = "rulers")
    public Object[][] provideRulersData() {
        return new Object[][]{
                {"leszko"},
                {"popiel"},
                {"piast kolodziej"},
                {"siemowit"},
                {"lestek"},
                {"siemomysl"},
                {"mieszko"}
        };
    }

    @DataProvider(name = "rulers2")
    public Object[][] provideRulerz2Data() {
        return new Object[][]{
                {"LESZKO"},
                {"POPIEL\n" +
                        "PIAST KOLODZIEJ\n" +
                        "SIEMOWIT\n" +
                        "LESTEK"},
                {"SIEMOMYSL"},
                {"MIESZKO"}
        };
    }

    @Test(dataProvider = "rulers")
    public void testLowerCasePeopleConsumer(String ruler) {
        var consumer = new StringConsumerWithFactory();
        consumer.consumePeople(rulerNames, createToLowerCaseStringConsumer());
        assertThat(this.newSystemOutputByteArray.toString(), CoreMatchers.containsString(ruler));
    }

    @Test(dataProvider = "rulers2")
    public void testUpperCasePeopleConsumer(String ruler) {

        var consumer = new StringConsumerWithFactory();
        consumer.consumePeople(rulerNames, createToUpperCaseStringConsumer());
        assertThat(this.newSystemOutputByteArray.toString(), CoreMatchers.containsString(ruler));
    }

    @Test
    public void testConcatenationConsumer() {
        var consumer = new StringConsumerWithFactory();
        consumer.consumePeopleList(rulerNames, concatConsumer());
        assertThat(this.newSystemOutputByteArray.toString(), CoreMatchers.containsString("LestekSiemomyslMieszko"));
    }

    @AfterSuite
    public void restoreSystemOut() {
        System.setOut(oldSystemOutput);
    }
}
