package com.zenpanda.util;

import com.zenpanda.constants.Constants;
import com.zenpanda.exception.InvalidShiftDurationException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Util {

    private static boolean isWeekend(Calendar calendar) {
        boolean isSaturday = calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;
        boolean isSunday = calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
        return isSaturday || isSunday;
    }

    public static List<Date> getWorkingDates(Date startDate, int scheduleSpan) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        List<Date> workingDates = new ArrayList<>();

        for (int scheduleSpanCounter = scheduleSpan; scheduleSpanCounter > 0;) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            if(isWeekend(calendar))
                continue;
            workingDates.add(calendar.getTime());
            scheduleSpanCounter--;
        }

        return workingDates;
    }

    public static Date convertStringToDate(String date) throws ParseException {
        if (date == null || date.equals("")) {
            return new Date();
        }
        return new SimpleDateFormat("dd-MM-yyyy").parse(date);
    }

    public static int shiftsPerDay() throws InvalidShiftDurationException {
        if(Constants.SHIFT_DURATION_IN_HOURS > 24)
            throw new InvalidShiftDurationException();

        return 24 / Constants.SHIFT_DURATION_IN_HOURS;
    }

    public static int totalHoursOfShift(int noOfShifts) throws InvalidShiftDurationException {
        return noOfShifts * Constants.SHIFT_DURATION_IN_HOURS;
    }
}
