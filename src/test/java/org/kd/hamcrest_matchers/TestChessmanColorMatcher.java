package org.kd.hamcrest_matchers;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class TestChessmanColorMatcher {

    @Test
    @Ignore//TODO
    public void testRegularExpressionMatcher() {
        Chessman s = new Chessman(new BoardField("a1"), 'W');
        Chessman chessmanToCompare = new Chessman(new BoardField("a1"), 'w');
        //assertThat(s, ChessmanColorMatcher.matchesChessman(chessmanToCompare, new Board()));
        fail("not implemented yet");
    }

}
