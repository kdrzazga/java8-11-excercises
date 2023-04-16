package org.kd.maps;

import org.testng.annotations.Test;
import org.kd.maps.ChessboardFactory.BoardField;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ChessboardTest {

    @Test
    public void testChessboardPositive() {
        var chessboard = new ChessboardFactory().createFields();

        assertTrue(chessboard.contains(new BoardField('a', 1)));
        assertTrue(chessboard.contains(new BoardField('h', 8)));
        assertTrue(chessboard.contains(new BoardField('b', 3)));
    }

    @Test
    public void testChessboardNegative() {
        var chessboard = new ChessboardFactory().createFields();

        assertFalse(chessboard.contains(new BoardField('i', 1)));
        assertFalse(chessboard.contains(new BoardField('a', 0)));
    }
}
