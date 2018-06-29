package com.zenpanda.service.fixtures;

import com.zenpanda.entity.Engineer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class ScheduleServiceFixture1 {

    public static final List<Engineer> availableEngineers = new ArrayList<>(
            Arrays.asList(
                    new Engineer("1", "Utkarsh 1"),
                    new Engineer("2", "Utkarsh 2")
            )
    );
}
