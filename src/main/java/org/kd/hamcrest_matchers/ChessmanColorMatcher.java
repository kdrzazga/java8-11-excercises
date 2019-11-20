package org.kd.hamcrest_matchers;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class ChessmanColorMatcher extends TypeSafeMatcher<Character> {

    private final Chessman originalChessman;
    private final Board board;

    public ChessmanColorMatcher(final Chessman originalChessman, Board board) {
        this.originalChessman = originalChessman;
        this.board = board;
    }

    //@Override
    public void describeTo(final Description description) {
        description.appendText("matches regular expression=`" + originalChessman + "`");
    }

    @Override
    public boolean matchesSafely(final Character color) {
        for (Chessman chessmanOnBoard : board.chessmen)
            if (chessmanOnBoard.side != color)
                return false;
        return true;
    }


    // matcher method you can call on this matcher class
    public static ChessmanColorMatcher matchesChessman(final Chessman chessman, Board board) {
        return new ChessmanColorMatcher(chessman, board);
    }
}
