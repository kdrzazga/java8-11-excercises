package org.kd.hamcrest_matchers;

import java.util.ArrayList;
import java.util.List;


public class Board {

    public final List<Chessman> chessmen = new ArrayList<>(8);

    public Board() {
        for (int row = 0; row < 4; row++)
            for (int col = 0; col < 4; col++)
                chessmen.add(new Chessman(new BoardField(row, col), 'w'));
        for (int row = 4; row < 8; row++)
            for (int col = 4; col < 8; col++)
                chessmen.add(new Chessman(new BoardField(row, col), 'b'));
    }
}
