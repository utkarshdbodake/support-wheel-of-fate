package com.zenpanda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Schedule entity has below json format:
 *
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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    private List<SingleDaySchedule> schedule;
}
