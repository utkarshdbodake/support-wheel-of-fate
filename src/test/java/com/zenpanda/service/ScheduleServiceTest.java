package com.zenpanda.service;

import com.zenpanda.rules.fixtures.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ScheduleServiceTest {

    /**
     * Engineer is not on 2 consecutive days.
     * @throws Exception
     */
    @Test
    public void consecutiveDayRuleTest1() throws Exception {
        ScheduleService scheduleService = new ScheduleService();
//        scheduleService.getSchedule("");
    }
}
