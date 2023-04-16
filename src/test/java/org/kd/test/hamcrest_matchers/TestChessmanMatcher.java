package org.kd.test.hamcrest_matchers;


import org.hamcrest.MatcherAssert;
import org.kd.hamcrest_matchers.BoardField;
import org.kd.hamcrest_matchers.Chessman;
import org.kd.hamcrest_matchers.ChessmanMatcher;
import org.testng.annotations.Test;

public class TestChessmanMatcher {

    @Test
    public void testRegularExpressionMatcher() {
        Chessman s = new Chessman(new BoardField("a1"), 'W');
        MatcherAssert.assertThat(s, ChessmanMatcher.matchesChessman(new Chessman(new BoardField("a1"), 'w')));
    }

}
