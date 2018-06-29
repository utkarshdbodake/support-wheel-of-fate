package com.zenpanda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * SingleDaySchedule entity has below json format:
 *
        {
            "date": 24-09-2018,
            "engineers": [
                { engineer 1 },
                { engineer 2 },
            ]
        }
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingleDaySchedule {

    String date;
    List<Engineer> engineers;
}
