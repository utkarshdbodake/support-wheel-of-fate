package com.zenpanda.scheduler;

import com.zenpanda.entity.Engineer;
import com.zenpanda.entity.SingleDaySchedule;

import java.util.Arrays;
import java.util.Date;

public class Scheduler {

    public static SingleDaySchedule scheduleForSingleDay() {
        return new SingleDaySchedule(
                new Date(),
                Arrays.asList(
                        new Engineer("1", "utki 1"),
                        new Engineer("2", "utki 2")
                )
        );
    }
}
