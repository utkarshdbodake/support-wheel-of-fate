package com.zenpanda.rules;

import com.zenpanda.rules.fixtures.ConsecutiveDayFixture1;
import com.zenpanda.rules.fixtures.ConsecutiveDayFixture2;
import com.zenpanda.rules.fixtures.ConsecutiveDayFixture3;
import com.zenpanda.rules.fixtures.ConsecutiveDaySample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class ConsecutiveDayRuleTest {

    /**
     * Engineer is not on 2 consecutive days.
     * @throws Exception
     */
    @Test
    public void consecutiveDayRuleTest1() throws Exception {
        ConsecutiveDaySample consecutiveDaySample = ConsecutiveDayFixture1.getConsecutiveDaySample();

        boolean outcome = new ConsecutiveDayRule().isValid(
                consecutiveDaySample.getEngineer(),
                consecutiveDaySample.getNoOfShiftsPerEngineerMap(),
                consecutiveDaySample.getSingleDaySchedule(),
                consecutiveDaySample.getSchedule()
        );

        assertThat(outcome, is(true));
    }

    /**
     * Engineer is on 2 consecutive days.
     * @throws Exception
     */
    @Test
    public void consecutiveDayRuleTest2() throws Exception {
        ConsecutiveDaySample consecutiveDaySample = ConsecutiveDayFixture2.getConsecutiveDaySample();

        boolean outcome = new ConsecutiveDayRule().isValid(
                consecutiveDaySample.getEngineer(),
                consecutiveDaySample.getNoOfShiftsPerEngineerMap(),
                consecutiveDaySample.getSingleDaySchedule(),
                consecutiveDaySample.getSchedule()
        );

        assertThat(outcome, is(false));
    }

    /**
     * Engineer is not on 2 consecutive days - with empty Schedule.
     * @throws Exception
     */
    @Test
    public void consecutiveDayRuleTest3() throws Exception {
        ConsecutiveDaySample consecutiveDaySample = ConsecutiveDayFixture3.getConsecutiveDaySample();

        boolean outcome = new ConsecutiveDayRule().isValid(
                consecutiveDaySample.getEngineer(),
                consecutiveDaySample.getNoOfShiftsPerEngineerMap(),
                consecutiveDaySample.getSingleDaySchedule(),
                consecutiveDaySample.getSchedule()
        );

        assertThat(outcome, is(true));
    }
}
