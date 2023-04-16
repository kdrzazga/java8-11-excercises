package org.kd.smallapps;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMarks {
    /*
    stwórz mapę, która będzie przechowywać dane uczniów (imię, nazwisko) oraz oceny. Następnie wyświetl dane wszystkich uczniów i średnią ocen każdego z nich
     */

    public static void main(String[] args) {

    new StudentMarks().students();
    }

    private void students(){
        var markStudentMap = Map.of(new Student("Adas", "Niezgodka"), List.of(3.0, 4.5),
                new Student("Ala", "Makota"), List.of(4.5, 3.5));

        for (var key : markStudentMap.keySet()){
             var stats = markStudentMap.get(key).stream().collect(Collectors.averagingDouble(Double::doubleValue));
            System.out.println(key.name + " " +key.lastName + " " + stats);
        }}

    class Student{
        private String name;
        private String lastName;

        public Student(String name, String lastName){
            this.name = name;
            this.lastName = lastName;
        }
    }
}
