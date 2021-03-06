package org.kd.function;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddDaysTest {

    @Test
    public void addDaysTest(){
        var today = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

        var future = Calendar.getInstance();
        future.setTime(new LongFunctionsFactory().addDays.apply(7 * 100_000));

        assertEquals(today, future.get(Calendar.DAY_OF_WEEK));
    }
}
