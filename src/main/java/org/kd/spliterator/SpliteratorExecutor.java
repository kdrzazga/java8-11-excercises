package org.kd.spliterator;

import org.kd.Person;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SpliteratorExecutor {

    public static List<Person> generateElements() {

        return Stream.generate(() -> new Person(randomName(), randomAge()))
                .limit(35000)
                .collect(Collectors.toList());
    }

    private static int randomAge() {
        return new Random().nextInt(50) + 1;
    }

    private static String randomName() {
        var names = List.of("Adas", "Krzysiek", "Michal", "Antosia", "Ula");
        return names.get(new Random().nextInt(names.size()));
    }

}
