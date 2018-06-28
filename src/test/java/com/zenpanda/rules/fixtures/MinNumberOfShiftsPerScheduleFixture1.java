package com.zenpanda.rules.fixtures;

import com.zenpanda.entity.Engineer;
import com.zenpanda.entity.Schedule;
import com.zenpanda.entity.SingleDaySchedule;
import lombok.Getter;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// Fixture for engineer is not on consecutive days.
public class MinNumberOfShiftsPerScheduleFixture1 {

    private static Engineer engineer1 = new Engineer("1", "Sam 1");
    private static Engineer engineer2 = new Engineer("2", "Sam 2");
    private static Engineer engineer3 = new Engineer("3", "Sam 3");
    private static Engineer engineer4 = new Engineer("4", "Sam 4");
    private static Engineer engineer5 = new Engineer("5", "Sam 5");
    private static Engineer engineer6 = new Engineer("6", "Sam 6");
    private static Engineer engineer7 = new Engineer("7", "Sam 7");
    private static Engineer engineer8 = new Engineer("8", "Sam 8");

    private static Map<Engineer, Integer> noOfShiftsPerEngineerMap = new HashMap<Engineer, Integer>() {{
        put(engineer1, 5);
        put(engineer2, 1);
        put(engineer3, 1);
        put(engineer4, 1);
        put(engineer5, 1);
        put(engineer6, 1);
    }};
    private static SingleDaySchedule singleDaySchedule1 = null;

    private static Schedule schedule = null;

    @Getter
    public static ConsecutiveDaySample consecutiveDaySample = new ConsecutiveDaySample(
            engineer1,
            noOfShiftsPerEngineerMap,
            singleDaySchedule1,
            schedule
    );
}

