package com.zenpanda.rules.fixtures;

import com.zenpanda.entity.Engineer;
import com.zenpanda.entity.Schedule;
import com.zenpanda.entity.SingleDaySchedule;
import lombok.Getter;
import java.util.*;

// Fixture for engineer is not on consecutive days.
public class MaxHoursPerDayFixture1 {

    private static Engineer engineer1 = new Engineer("1", "Sam 1");

    private static Map<Engineer, Integer> noOfShiftsPerEngineerMap = null
            ;
    private static SingleDaySchedule singleDaySchedule1 = new SingleDaySchedule(
            new Date(),
            Arrays.asList(
                    engineer1
            )
    );

    private static Schedule schedule = new Schedule(
            Arrays.asList()
    );

    @Getter
    public static ConsecutiveDaySample consecutiveDaySample = new ConsecutiveDaySample(
            engineer1,
            noOfShiftsPerEngineerMap,
            singleDaySchedule1,
            schedule
    );
}

