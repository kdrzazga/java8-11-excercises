package org.kd.hamcrest_matchers;

public final class BoardField {

    private int x;
    private int y;
    public static final String availableXs = "abcdefgh";
    private static final String INDEX_OOB_MSG = "Index out of bounds for ";

    public BoardField(int tableX, int tableY) {
        this.setTableXCoord(tableX);
        this.setTableYCoord(tableY);
    }

    public BoardField(char x, int y) {
        this.setBoardXCoord(x);
        this.setBoardYCoord(y);
    }

    public BoardField(String field) {
        this.setBoardXCoord(field.charAt(0));
        this.setBoardYCoord(Integer.parseInt("" + field.charAt(1)));
    }

    public void setBoardYCoord(int y) {
        if (y >= 1 && y <= 8) {
            this.y = y - 1;
        } else
            throw new RuntimeException(INDEX_OOB_MSG + " y=" + y);
    }

    public void setBoardXCoord(char x) {
        x = ("" + x).toLowerCase().charAt(0);
        this.x = availableXs.indexOf(x);

        if (this.x == -1)
            throw new RuntimeException(INDEX_OOB_MSG + " x=" + x);
    }

    public void setTableXCoord(int value) {
        this.x = value;
    }

    public void setTableYCoord(int value) {
        this.y = value;
    }

    public boolean equals(BoardField boardField){
        return (this.x == boardField.x)
                && (this.y == boardField.y);
    }
}