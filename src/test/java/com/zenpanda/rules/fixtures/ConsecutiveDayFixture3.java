package com.zenpanda.rules.fixtures;

import com.zenpanda.entity.Engineer;
import com.zenpanda.entity.Schedule;
import com.zenpanda.entity.SingleDaySchedule;
import lombok.Getter;
import java.util.*;

// Fixture for engineer is not on consecutive days.
public class ConsecutiveDayFixture3 {

    private static Engineer engineer1 = new Engineer("1", "Sam 1");
    private static Engineer engineer2 = new Engineer("2", "Sam 2");
    private static Engineer engineer3 = new Engineer("3", "Sam 3");
    private static Engineer engineer4 = new Engineer("4", "Sam 4");

    private static Map<Engineer, Integer> noOfShiftsPerEngineerMap = new HashMap<Engineer, Integer>() {{
    }};
    private static SingleDaySchedule singleDaySchedule1 = new SingleDaySchedule(
            new Date(),
            Arrays.asList(
                    engineer1,
                    engineer2
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
