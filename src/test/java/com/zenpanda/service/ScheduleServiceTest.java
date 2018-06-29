package com.zenpanda.service;

import com.zenpanda.dao.EngineerDao;
import com.zenpanda.entity.Schedule;
import com.zenpanda.rules.fixtures.*;
import com.zenpanda.service.fixtures.ScheduleServiceFixture1;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

//        EngineerDao engineerDao = mock(EngineerDao.class);
//        when(engineerDao.getEngineers()).thenReturn(ScheduleServiceFixture1.availableEngineers);
//
//        ScheduleService scheduleService = new ScheduleService();
//        Schedule schedule = scheduleService.getSchedule("1-1-2018");
//        System.out.println("************** test schedule: " + schedule);
    }
}
