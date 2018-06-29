package com.zenpanda.rules.fixtures;

import com.zenpanda.entity.Engineer;
import com.zenpanda.entity.Schedule;
import com.zenpanda.entity.SingleDaySchedule;
import com.zenpanda.util.Util;
import lombok.Getter;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// Fixture for engineer is not on consecutive days.
public class MaxHoursPerDayFixture2 {

    private static Engineer engineer1 = new Engineer("1", "Sam 1");
    private static Engineer engineer2 = new Engineer("2", "Sam 2");

    private static Map<Engineer, Integer> noOfShiftsPerEngineerMap = null;
    private static SingleDaySchedule singleDaySchedule1 = new SingleDaySchedule(
            Util.convertDateToString(new Date()),
            Arrays.asList(
                    engineer1
            )
    );

    private static Schedule schedule = new Schedule(
            Arrays.asList()
    );

    @Getter
    public static ConsecutiveDaySample consecutiveDaySample = new ConsecutiveDaySample(
            engineer2,
            noOfShiftsPerEngineerMap,
            singleDaySchedule1,
            schedule
    );
}

