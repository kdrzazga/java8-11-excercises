package org.kd.maps;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ChessboardFactory {

    List<BoardField> createFields() {

        var result = new Vector<BoardField>();

        IntStream.rangeClosed('a', 'h')
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet())
                .forEach(letter -> IntStream.range(1, 8 + 1)
                        .boxed()
                        .collect(Collectors.toSet())
                        .forEach(number -> result
                                .add(new BoardField(letter, number))));

        return result;
    }

    static class BoardField {
        private char x;
        private int y;

        BoardField(char x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BoardField)) return false;
            BoardField that = (BoardField) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }
}
