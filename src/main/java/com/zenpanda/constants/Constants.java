package com.zenpanda.constants;

import org.springframework.stereotype.Component;

@Component
public class Constants {

    // No of days to provide the support
    public static int SCHEDULE_SPAN_IN_DAYS = 10;

    // No of hours in a shift
    public static int SHIFT_DURATION_IN_HOURS = 12;

    // Max hours of shift completed by an engineer in a schedule
    public static int MIN_HOURS_PER_ENGINEER_IN_SCHEDULE = 1 * 24;

    // Max hours of shift per day by an engineer
    public static int MAX_HOURS_OF_SHIFT_PER_DAY = 12;

    // Max hours of shift on consecutive days by an engineer
    public static int MAX_HOURS_OF_SHIFT_ON_CONSECUTIVE_DAYS = 12;
}
