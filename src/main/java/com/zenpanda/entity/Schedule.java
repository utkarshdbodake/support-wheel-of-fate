package com.zenpanda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    /*
        {
            "schedule": [
                {
                    "date": 24-09-2018,
                    "engineers": [
                        { engineer 1 },
                        { engineer 2 },
                    ]
                },
                { ... }
            ]
        }
     */
    private List<SingleDaySchedule> schedule;
}
