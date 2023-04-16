package org.kd.test.hamcrest_matchers;

import org.kd.hamcrest_matchers.BoardField;
import org.kd.hamcrest_matchers.Chessman;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class ChessmanColorMatcherTest {

    @Test
    @Ignore//TODO
    public void testRegularExpressionMatcher() {
        Chessman s = new Chessman(new BoardField("a1"), 'W');
        Chessman chessmanToCompare = new Chessman(new BoardField("a1"), 'w');
        //assertThat(s, ChessmanColorMatcher.matchesChessman(chessmanToCompare, new Board()));
        fail("not implemented yet");
    }

}
