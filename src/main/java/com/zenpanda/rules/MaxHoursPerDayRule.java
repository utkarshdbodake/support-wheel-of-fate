package com.zenpanda.rules;

import com.zenpanda.constants.Constants;
import com.zenpanda.entity.Engineer;
import com.zenpanda.entity.Schedule;
import com.zenpanda.entity.SingleDaySchedule;

import java.util.Collections;
import java.util.Map;

// Enforces rule: An engineer can do at most one half day shift in a day.
public class MaxHoursPerDayRule implements IRule {

    public boolean isValid(Engineer engineer,
                           Map<Engineer, Integer> noOfShiftsPerEngineerMap,
                           SingleDaySchedule singleDaySchedule,
                           Schedule schedule) {

        if (singleDaySchedule.getEngineers() == null)
            return true;
        int noOfShiftsPerDay = Collections.frequency(singleDaySchedule.getEngineers(), engineer);
        int totalHoursOfShiftPerDay = noOfShiftsPerDay * Constants.SHIFT_DURATION_IN_HOURS;
        return totalHoursOfShiftPerDay < Constants.MAX_HOURS_OF_SHIFT_PER_DAY;
    }
}
