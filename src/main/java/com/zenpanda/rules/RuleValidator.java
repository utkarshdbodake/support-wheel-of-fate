package com.zenpanda.rules;

import com.zenpanda.entity.Engineer;
import com.zenpanda.entity.Schedule;
import com.zenpanda.entity.SingleDaySchedule;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class RuleValidator {

    private static List<IRule> rules;
    static {
        rules = Arrays.asList(
                new MaxHoursPerDayRule(),
                new ConsecutiveDayRule(),
                new MinNumberOfShiftsPerScheduleRule()
        );
    }

    /**
     * Checks for all the rules and returns true if all the rules are valid.
     *
     * @param engineer
     * @param noOfShiftsPerEngineerMap
     * @param singleDaySchedule
     * @param schedule
     * @return
     */
    public static boolean areRulesValid(
            Engineer engineer,
            Map<Engineer, Integer> noOfShiftsPerEngineerMap,
            SingleDaySchedule singleDaySchedule,
            Schedule schedule) {
        return rules
                .stream()
                .allMatch(
                        r -> r.isValid(engineer, noOfShiftsPerEngineerMap, singleDaySchedule, schedule)
                );
    }
}
