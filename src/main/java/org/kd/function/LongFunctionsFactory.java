package org.kd.function;

import java.util.Calendar;
import java.util.Date;
import java.util.function.LongFunction;

public class LongFunctionsFactory {

    LongFunction<Boolean> isLongPositive = (a) -> a > 0;

    LongFunction<Date> addDays = (day) -> {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, Long.valueOf(day).intValue());
        return calendar.getTime();
    };
}
