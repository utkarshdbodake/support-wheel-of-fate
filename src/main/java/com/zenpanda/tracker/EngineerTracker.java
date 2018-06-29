package com.zenpanda.tracker;

import com.zenpanda.dao.EngineerDao;
import com.zenpanda.entity.Engineer;
import com.zenpanda.exception.NoAvailableEngineersException;

import java.util.List;

/**
 * Gets the engineers in sequential linear order.
 * Helps to traverse all the engineers in Round-robin fashion.
 */
public class EngineerTracker {

    private int index = 0;
    private List<Engineer> availableEngineers;

    public EngineerTracker() {
        index = 0;
        availableEngineers = new EngineerDao().getEngineers();
    }

    /**
     * Gets the available engineer. If no engineer is available, it throws out an NoAvailableEngineersException.
     * @return
     * @throws NoAvailableEngineersException
     */
    public Engineer getAvailableEngineer() throws NoAvailableEngineersException {

        if(index > availableEngineers.size() - 1) {
            throw new NoAvailableEngineersException();
        }
        Engineer engineer = availableEngineers.get(index);
        index++;
        return engineer;
    }

    /**
     * Resets the traversal pointer back to the start.
     */
    public void resetIndex() {
        index = 0;
    }
}
