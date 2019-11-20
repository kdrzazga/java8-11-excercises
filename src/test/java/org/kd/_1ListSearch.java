package org.kd;

import java.util.List;
import java.util.stream.Collectors;

class _1ListSearch {
    /*
    Mamy listę użytkowników: List<User> w obiekcie mamy dostęp do pola name. Wykorzystując stream, odnajdź tylko tych użytkowników, których imię to: "Janusz".
     */

    public static void main(String[] args) {
        var janusze = new _1ListSearch().filterUsers();
        janusze.forEach(j -> System.out.println(j.getName()));

    }

    private List<User> filterUsers() {
        var users = List.of(new User("Janusz"), new User("Grazyna"));
        return users.stream().filter(user -> "Janusz".equals(user.getName())).collect(Collectors.toList());
    }

    public class User {
        private String name;

        User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
