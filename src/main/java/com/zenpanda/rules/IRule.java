package com.zenpanda.rules;

import com.zenpanda.entity.Engineer;
import com.zenpanda.entity.Schedule;
import com.zenpanda.entity.SingleDaySchedule;

import java.util.Map;

public interface IRule {

    boolean isValid(Engineer engineer,
                    Map<Engineer, Integer> noOfShiftsPerEngineerMap,
                    SingleDaySchedule singleDaySchedule,
                    Schedule schedule);
}
