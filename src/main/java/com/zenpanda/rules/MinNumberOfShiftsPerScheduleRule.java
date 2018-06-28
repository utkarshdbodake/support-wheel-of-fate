package com.zenpanda.rules;

import com.zenpanda.constants.Constants;
import com.zenpanda.entity.Engineer;
import com.zenpanda.entity.Schedule;
import com.zenpanda.entity.SingleDaySchedule;
import com.zenpanda.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

// Enforces rule: Each engineer should have completed one whole day of support in any 2 week period.
public class MinNumberOfShiftsPerScheduleRule implements IRule {

    private static final Logger logger = LogManager.getLogger(MinNumberOfShiftsPerScheduleRule.class);

    public boolean isValid(Engineer engineer,
                           Map<Engineer, Integer> noOfShiftsPerEngineerMap,
                           SingleDaySchedule singleDaySchedule,
                           Schedule schedule) {

        try {
            if (noOfShiftsPerEngineerMap.get(engineer) == null)
                return true;

            int totalHoursOfShift = Util.totalHoursOfShift(noOfShiftsPerEngineerMap.get(engineer));
            if (totalHoursOfShift >= Constants.MIN_HOURS_PER_ENGINEER_IN_SCHEDULE)
                return false;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return true;
    }
}
