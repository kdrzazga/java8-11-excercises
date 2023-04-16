package org.kd.functional_interface.consumer;

import java.util.List;
import java.util.function.Consumer;

public class StringConsumerWithFactory {

    void consumePeople(List<String> people, Consumer<String> consumer) {
        for (String person : people) {
            consumer.accept(person);
        }
    }

    void consumePeopleList(List<String> people, Consumer<List<String>> consumer) {
        consumer.accept(people);
    }

    static Consumer<String> createToLowerCaseStringConsumer(){
        return (x) -> System.out.println(x.toLowerCase());
    }

    static Consumer<String> createToUpperCaseStringConsumer(){
        return (x) -> System.out.println(x.toUpperCase());
    }

    static Consumer<List<String>> concatConsumer(){
        return (list) -> {
            var sb = new StringBuilder();
            list.forEach(s -> sb.append(s));
            System.out.println(sb);
        };
    }
}