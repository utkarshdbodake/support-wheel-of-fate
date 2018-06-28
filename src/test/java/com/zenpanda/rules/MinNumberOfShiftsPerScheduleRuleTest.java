package com.zenpanda.rules;

import com.zenpanda.rules.fixtures.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MinNumberOfShiftsPerScheduleRuleTest {

    /**
     * Engineer has completed one whole day of support in any 2 week period.
     * @throws Exception
     */
    @Test
    public void minNumberOfShiftsPerScheduleRuleTest1() throws Exception {
        ConsecutiveDaySample consecutiveDaySample = MinNumberOfShiftsPerScheduleFixture1.getConsecutiveDaySample();

        boolean outcome = new MinNumberOfShiftsPerScheduleRule().isValid(
                consecutiveDaySample.getEngineer(),
                consecutiveDaySample.getNoOfShiftsPerEngineerMap(),
                consecutiveDaySample.getSingleDaySchedule(),
                consecutiveDaySample.getSchedule()
        );

        assertThat(outcome, is(false));
    }

    /**
     * Engineer hasn't completed one whole day of support in any 2 week period.
     * @throws Exception
     */
    @Test
    public void minNumberOfShiftsPerScheduleRuleTest2() throws Exception {
        ConsecutiveDaySample consecutiveDaySample = MinNumberOfShiftsPerScheduleFixture2.getConsecutiveDaySample();

        boolean outcome = new MinNumberOfShiftsPerScheduleRule().isValid(
                consecutiveDaySample.getEngineer(),
                consecutiveDaySample.getNoOfShiftsPerEngineerMap(),
                consecutiveDaySample.getSingleDaySchedule(),
                consecutiveDaySample.getSchedule()
        );

        assertThat(outcome, is(true));
    }
}
