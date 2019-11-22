package org.kd.hamcrest_matchers;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestChessmanMatcher {

    @Test
    public void testRegularExpressionMatcher() {
        Chessman s = new Chessman(new BoardField("a1"), 'W');
        assertThat(s, ChessmanMatcher.matchesChessman(new Chessman(new BoardField("a1"), 'w')));
    }

}
