package com.zenpanda.service;

import com.zenpanda.constants.Constants;
import com.zenpanda.entity.Engineer;
import com.zenpanda.entity.Schedule;
import com.zenpanda.entity.SingleDaySchedule;
import com.zenpanda.exception.InvalidShiftDurationException;
import com.zenpanda.exception.NoAvailableEngineersException;
import com.zenpanda.exception.ScheduleGenerationException;
import com.zenpanda.rules.RuleValidator;
import com.zenpanda.scheduler.EngineerTracker;
import com.zenpanda.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScheduleService {

    private static final Logger logger = LogManager.getLogger(ScheduleService.class);
    private LinkedHashMap<Engineer, Integer> noOfShiftsPerEngineerMap = new LinkedHashMap<>();

    /**
     * Tracks the counter of number of shifts done by the engineers.
     *
     * @param engineer
     */
    private void updateNoOfShiftsPerEngineer(Engineer engineer) {

        if (noOfShiftsPerEngineerMap.get(engineer)!=null) {
            noOfShiftsPerEngineerMap.put(
                    engineer,
                    noOfShiftsPerEngineerMap.get(engineer) + 1
            );
        } else {
            noOfShiftsPerEngineerMap.put(engineer, 1);
        }
    }

    /**
     * Constructs schedule for the single day (i.e. for the given working date).
     *
     * @param workingDate
     * @param schedule
     * @return
     * @throws InvalidShiftDurationException
     */
    private SingleDaySchedule constructSingleDaySchedule(Date workingDate, int shiftsPerDay, Schedule schedule) {

        SingleDaySchedule singleDaySchedule = new SingleDaySchedule();
        singleDaySchedule.setDate(workingDate);
        List<Engineer> availableEngineers = new ArrayList<>();
        int noAvailableEngineersExceptionCounter = 0;

        for(int i = 0; i < shiftsPerDay;) {
            Engineer availableEngineer;
            try {
                availableEngineer = EngineerTracker.getAvailableEngineer();
            } catch (NoAvailableEngineersException e) {
                logger.error("No available engineers found: " + e);
                noAvailableEngineersExceptionCounter ++;
                if (noAvailableEngineersExceptionCounter >= 2)
                    break;
                EngineerTracker.resetIndex();
                continue;
            }

            boolean areRulesValid = RuleValidator.areRulesValid(
                    availableEngineer, noOfShiftsPerEngineerMap, singleDaySchedule, schedule);
            if (!areRulesValid)
                continue;

            updateNoOfShiftsPerEngineer(availableEngineer);
            availableEngineers.add(i, availableEngineer);
            i++;
        }
        singleDaySchedule.setEngineers(availableEngineers);

        return singleDaySchedule;
    }

    /**
     * Constructs the support schedule for engineers for the provided working dates.
     *
     * @param workingDates
     * @return
     * @throws InvalidShiftDurationException
     */
    private Schedule constructSchedule(List<Date> workingDates) throws InvalidShiftDurationException {

        System.out.println("********** Constants.SCHEDULE_SPAN_IN_DAYS: " + Constants.SCHEDULE_SPAN_IN_DAYS);
        System.out.println("********** workingDates: " + workingDates);
        int shiftsPerDay = Util.shiftsPerDay();
        Schedule schedule = new Schedule(new ArrayList<>());

        for(Date workingDate : workingDates) {
            SingleDaySchedule singleDaySchedule = constructSingleDaySchedule(workingDate, shiftsPerDay, schedule);
            schedule.getSchedule().add(singleDaySchedule);
        }

        System.out.println("********** schedule: " + schedule);
        return schedule;
    }

    /**
     * Calculates the working dates & then gets the schedule for the support,
     * it allocates the engineers based upon the predefined rules.
     *
     * @param startDateStr Start date of the schedule. Has format: dd-MM-yyyy
     * @return
     */
    public Schedule getSchedule(String startDateStr) {

        try {
            Date startDate = Util.convertStringToDate(startDateStr);
            List<Date> workingDates = Util.getWorkingDates(startDate, Constants.SCHEDULE_SPAN_IN_DAYS);
            return constructSchedule(workingDates);
        }
        catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
