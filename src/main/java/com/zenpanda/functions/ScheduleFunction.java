package com.zenpanda.functions;

import com.zenpanda.entity.Schedule;
import com.zenpanda.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Map;
import java.util.function.Function;

@Component("scheduleFunction")
public class ScheduleFunction implements Function<Map<String, String>, Schedule> {

    private static final Logger logger = LogManager.getLogger(ScheduleFunction.class);
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleFunction(final ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @Override
    public Schedule apply(final Map<String, String> request) {
        logger.debug("called function 'uppercaseFunction': " + request);

        String startDate = request.get("startDate");

        return scheduleService.getSchedule(startDate);
    }
}