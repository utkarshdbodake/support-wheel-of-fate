package com.zenpanda.rules;

import com.zenpanda.constants.Constants;
import com.zenpanda.entity.Engineer;
import com.zenpanda.entity.Schedule;
import com.zenpanda.entity.SingleDaySchedule;

import java.util.Collections;
import java.util.Map;

/**
 * Checks for rule: An engineer cannot have half day shifts on consecutive days.
 */
public class ConsecutiveDayRule implements IRule {

    private int calculateHoursOfShift(SingleDaySchedule singleDaySchedule, Engineer engineer) {
        int noOfShifts = Collections.frequency(singleDaySchedule.getEngineers(), engineer);
        return noOfShifts * Constants.SHIFT_DURATION_IN_HOURS;
    }

    public boolean isValid(Engineer engineer,
                           Map<Engineer, Integer> noOfShiftsPerEngineerMap,
                           SingleDaySchedule singleDaySchedule,
                           Schedule schedule) {

        // Calculate total hours of shift done by the selected engineer today
        if (singleDaySchedule.getEngineers() == null)
            return true;
        int totalHoursOfShiftToday = calculateHoursOfShift(singleDaySchedule, engineer);

        // Calculate total hours of shift done by the selected engineer yesterday
        int lastIndex = schedule.getSchedule().size() - 1 ;
        if (lastIndex < 0)
            return true;
        SingleDaySchedule previousDaySingleDaySchedule = schedule.getSchedule().get(lastIndex);
        if (previousDaySingleDaySchedule.getEngineers() == null)
            return true;
        int totalHoursOfShiftYesterday = calculateHoursOfShift(previousDaySingleDaySchedule, engineer);

        // Calculate total hours of shift done by the selected engineer on consecutive days
        int totalHoursOfShiftOnConsecutiveDays = totalHoursOfShiftToday + totalHoursOfShiftYesterday;

        return totalHoursOfShiftOnConsecutiveDays <= Constants.MAX_HOURS_OF_SHIFT_ON_CONSECUTIVE_DAYS;
    }
}
