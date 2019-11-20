package org.kd.hamcrest_matchers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class TestChessmanColorMatcher {

    @Test
    public void testRegularExpressionMatcher() {
        Chessman s = new Chessman(new BoardField("a1"), 'W');
        Chessman chessmanToCompare = new Chessman(new BoardField("a1"), 'w');
        //assertThat(s, ChessmanColorMatcher.matchesChessman(chessmanToCompare, new Board()));
        fail("not implemented yet");
    }

}
