package com.zenpanda.functions;

import com.zenpanda.entity.Schedule;
import com.zenpanda.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;

@Component("scheduleFunction")
public class ScheduleFunction implements Function<Map<String, String>, Schedule> {
    @Autowired
    private final ScheduleService scheduleService;


    public ScheduleFunction(final ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @Override
    public Schedule apply(final Map<String, String> request) {
        String startDate = request.get("startDate");
        return scheduleService.getSchedule(startDate);
    }
}