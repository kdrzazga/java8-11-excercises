package org.kd.hamcrest_matchers;

public class Chessman {

    private BoardField field;
    public char side;

    Chessman() {
    }

    public Chessman(Chessman chessman) {
        this.field = chessman.getField();
    }

    public Chessman(BoardField field, char side) {
        this.field = field;
        this.side = side;
    }


    public BoardField getField() {
        return field;
    }

    public void setField(BoardField field) {
        this.field = field;
    }
}