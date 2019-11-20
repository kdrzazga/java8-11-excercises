package org.kd.hamcrest_matchers;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class ChessmanMatcher extends TypeSafeMatcher<Chessman> {

    private final Chessman originalChessman;

    public ChessmanMatcher(final Chessman originalChessman) {
        this.originalChessman = originalChessman;
    }

    //@Override
    public void describeTo(final Description description) {
        description.appendText("matches regular expression=`" + originalChessman + "`");
    }

    @Override
    public boolean matchesSafely(final Chessman chessmanToCmp) {
        return chessmanToCmp.getField().getClass().equals(originalChessman.getField().getClass());
    }


    // matcher method you can call on this matcher class
    public static ChessmanMatcher matchesChessman(final Chessman regex) {
        return new ChessmanMatcher(regex);
    }
}
