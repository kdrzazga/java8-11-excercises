package org.kd.functional_interface.consumer;

import java.util.List;
import java.util.function.Consumer;

public class StringConsumerWithFactory {

    public void consumePeople(List<String> people, Consumer<String> consumer) {
        for (String person : people) {
            consumer.accept(person);
        }
    }

    public void consumePeopleList(List<String> people, Consumer<List<String>> consumer) {
        consumer.accept(people);
    }

    public static Consumer<String> createToLowerCaseStringConsumer(){
        return (x) -> System.out.println(x.toLowerCase());
    }

    public static Consumer<String> createToUpperCaseStringConsumer(){
        return (x) -> System.out.println(x.toUpperCase());
    }

    public static Consumer<List<String>> concatConsumer(){
        return (list) -> {
            var sb = new StringBuilder();
            list.forEach(s -> sb.append(s));
            System.out.println(sb);
        };
    }
}