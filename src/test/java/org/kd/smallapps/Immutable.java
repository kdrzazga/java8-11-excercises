package org.kd.smallapps;

import java.util.Date;

public class Immutable {
    /*
    Stwórz klasę niemutowalną.
     */
    private final int field;
    private final Date date;

    public Immutable(int field, Date date) {
        this.field = field;
        this.date = new Date(date.getTime());
    }

    @Override
    protected Object clone() {
        return new Immutable(this.field, this.date);
    }
}