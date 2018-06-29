package com.zenpanda.rules.fixtures;

import com.zenpanda.entity.Engineer;
import com.zenpanda.entity.Schedule;
import com.zenpanda.entity.SingleDaySchedule;
import com.zenpanda.util.Util;
import lombok.Getter;
import java.util.*;

// Fixture for engineer is not on consecutive days.
public class ConsecutiveDayFixture1 {

    private static Engineer engineer1 = new Engineer("1", "Sam 1");
    private static Engineer engineer2 = new Engineer("2", "Sam 2");
    private static Engineer engineer3 = new Engineer("3", "Sam 3");
    private static Engineer engineer4 = new Engineer("4", "Sam 4");
    private static Engineer engineer5 = new Engineer("5", "Sam 5");
    private static Engineer engineer6 = new Engineer("6", "Sam 6");
    private static Engineer engineer7 = new Engineer("7", "Sam 7");
    private static Engineer engineer8 = new Engineer("8", "Sam 8");

    private static Map<Engineer, Integer> noOfShiftsPerEngineerMap = new HashMap<Engineer, Integer>() {{
        put(engineer1, 1);
        put(engineer2, 1);
        put(engineer3, 1);
        put(engineer4, 1);
        put(engineer5, 1);
        put(engineer6, 1);
    }};
    private static SingleDaySchedule singleDaySchedule1 = new SingleDaySchedule(
            Util.convertDateToString(new Date()),
            Arrays.asList(
                    engineer1,
                    engineer2
            )
    );
    private static SingleDaySchedule singleDaySchedule2 = new SingleDaySchedule(
            Util.convertDateToString(new Date()),
            Arrays.asList(
                    engineer3,
                    engineer4
            )
    );
    private static SingleDaySchedule singleDaySchedule3 = new SingleDaySchedule(
            Util.convertDateToString(new Date()),
            Arrays.asList(
                    engineer5,
                    engineer6
            )
    );
    private static SingleDaySchedule singleDaySchedule4 = new SingleDaySchedule(
            Util.convertDateToString(new Date()),
            Arrays.asList(
                    engineer7,
                    engineer8
            )
    );
    private static Schedule schedule = new Schedule(
            Arrays.asList(
                    singleDaySchedule1,
                    singleDaySchedule2,
                    singleDaySchedule3
            )
    );

    @Getter
    public static ConsecutiveDaySample consecutiveDaySample = new ConsecutiveDaySample(
            engineer7,
            noOfShiftsPerEngineerMap,
            singleDaySchedule4,
            schedule
    );
}
