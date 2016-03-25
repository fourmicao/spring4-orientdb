package com.hrb.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

/**
 * Created on 24/03/2016.
 */
@Component
public class FreeTimer {
    private DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/YYYY H:m");

    public String formattedCurrentTime() {
        DateTime dateTime = new DateTime();
        return fmt.print(dateTime);
    }
}
