package com.zenpanda.functions;

import com.zenpanda.entity.Schedule;
import com.zenpanda.service.ScheduleService;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;

@Component("scheduleFunction")
public class ScheduleFunction implements Function<Map<String, String>, Schedule> {

    @Override
    public Schedule apply(final Map<String, String> request) {
        String startDate = "";
        if (request != null && request.containsKey("startDate")) {
            startDate = request.get("startDate");
        }
        return new ScheduleService().getSchedule(startDate);
    }
}