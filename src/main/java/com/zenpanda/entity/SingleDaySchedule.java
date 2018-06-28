package com.zenpanda.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingleDaySchedule {

    /*
        {
            "date": 24-09-2018,
            "engineers": [
                { engineer 1 },
                { engineer 2 },
            ]
        }
     */
    @JsonFormat(pattern = "EEEE dd-MM-yyyy")
    Date date;
    List<Engineer> engineers;
}
