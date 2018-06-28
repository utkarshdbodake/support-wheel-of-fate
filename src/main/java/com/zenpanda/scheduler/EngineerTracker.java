package com.zenpanda.scheduler;

import com.zenpanda.entity.Engineer;
import com.zenpanda.exception.NoAvailableEngineersException;

import java.util.Arrays;
import java.util.List;

public class EngineerTracker {

    private static int index;
    private static List<Engineer> availableEngineers;

    static {
        index = 0;
        availableEngineers = Arrays.asList(
                new Engineer("1", "utk 1"),
                new Engineer("2", "utk 2"),
                new Engineer("3", "utk 3"),
                new Engineer("4", "utk 4"),
                new Engineer("5", "utk 5")
        );
    }

    public static Engineer getAvailableEngineer() throws NoAvailableEngineersException {

        if(index > availableEngineers.size() - 1) {
            throw new NoAvailableEngineersException();
        }
        Engineer engineer = availableEngineers.get(index);
        index++;
        return engineer;
    }

    public static void resetIndex() {
        index = 0;
    }
}
