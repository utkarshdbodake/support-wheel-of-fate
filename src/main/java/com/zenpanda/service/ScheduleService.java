package com.zenpanda.service;

import com.zenpanda.constants.Constants;
import com.zenpanda.entity.Engineer;
import com.zenpanda.entity.Schedule;
import com.zenpanda.entity.SingleDaySchedule;
import com.zenpanda.exception.NoAvailableEngineersException;
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

    private void updateNoOfShiftsPerEngineer(Engineer availableEngineer) {

        if (noOfShiftsPerEngineerMap.get(availableEngineer)!=null) {
            noOfShiftsPerEngineerMap.put(
                    availableEngineer,
                    noOfShiftsPerEngineerMap.get(availableEngineer) + 1
            );
        } else {
            noOfShiftsPerEngineerMap.put(availableEngineer, 1);
        }
    }

    public Schedule getSchedule(String startDateStr) {
        Schedule schedule = new Schedule(new ArrayList<>());
        int noAvailableEngineersExceptionCounter = 0;

        try {
            Date startDate = Util.convertStringToDate(startDateStr);
            List<Date> workingDates = Util.getWorkingDates(startDate, Constants.SCHEDULE_SPAN_IN_DAYS);
            System.out.println("********** workingDates: " + workingDates);

            int shiftsPerDay = Util.shiftsPerDay();

            for(Date workingDate : workingDates) {

                SingleDaySchedule singleDaySchedule = new SingleDaySchedule();
                singleDaySchedule.setDate(workingDate);
                List<Engineer> availableEngineers = new ArrayList<>();

                for(int i = 0; i < shiftsPerDay;) {
                    Engineer availableEngineer;
                    try {
                        availableEngineer = EngineerTracker.getAvailableEngineer();
                    } catch (NoAvailableEngineersException e) {
                        noAvailableEngineersExceptionCounter ++;
                        if (noAvailableEngineersExceptionCounter >= 2)
                            break;
                        EngineerTracker.resetIndex();
                        continue;
                    }
                    boolean areRulesValid = RuleValidator.areRulesValid(
                            availableEngineer,
                            noOfShiftsPerEngineerMap,
                            singleDaySchedule,
                            schedule
                    );
                    if (!areRulesValid)
                        continue;

                    updateNoOfShiftsPerEngineer(availableEngineer);
                    availableEngineers.add(i, availableEngineer);
                    i++;
                }
                singleDaySchedule.setEngineers(availableEngineers);
                schedule.getSchedule().add(singleDaySchedule);
            }
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }

        System.out.println("********** schedule: " + schedule);
        return schedule;
    }
}
