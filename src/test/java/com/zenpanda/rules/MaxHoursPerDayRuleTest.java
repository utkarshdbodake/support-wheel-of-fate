package com.zenpanda.rules;

import com.zenpanda.rules.fixtures.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MaxHoursPerDayRuleTest {

    /**
     * Engineer does have more than half day shift.
     * @throws Exception
     */
    @Test
    public void maxHoursPerDayRuleTest1() throws Exception {
        ConsecutiveDaySample consecutiveDaySample = MaxHoursPerDayFixture1.getConsecutiveDaySample();

        boolean outcome = new MaxHoursPerDayRule().isValid(
                consecutiveDaySample.getEngineer(),
                consecutiveDaySample.getNoOfShiftsPerEngineerMap(),
                consecutiveDaySample.getSingleDaySchedule(),
                consecutiveDaySample.getSchedule()
        );

        assertThat(outcome, is(false));
    }

    /**
     * Engineer doesn't have more than half day shift.
     * @throws Exception
     */
    @Test
    public void maxHoursPerDayRuleTest2() throws Exception {
        ConsecutiveDaySample consecutiveDaySample = MaxHoursPerDayFixture2.getConsecutiveDaySample();

        boolean outcome = new MaxHoursPerDayRule().isValid(
                consecutiveDaySample.getEngineer(),
                consecutiveDaySample.getNoOfShiftsPerEngineerMap(),
                consecutiveDaySample.getSingleDaySchedule(),
                consecutiveDaySample.getSchedule()
        );

        assertThat(outcome, is(true));
    }
}
