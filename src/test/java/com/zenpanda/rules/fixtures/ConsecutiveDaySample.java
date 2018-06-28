package com.zenpanda.rules.fixtures;

import com.zenpanda.entity.Engineer;
import com.zenpanda.entity.Schedule;
import com.zenpanda.entity.SingleDaySchedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Map;

@Data
@AllArgsConstructor
public class ConsecutiveDaySample {
    private Engineer engineer;
    private Map<Engineer, Integer> noOfShiftsPerEngineerMap;
    private SingleDaySchedule singleDaySchedule;
    private Schedule schedule;
}
