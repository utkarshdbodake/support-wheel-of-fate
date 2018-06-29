package com.zenpanda.dao;

import com.zenpanda.entity.Engineer;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@Component
public class EngineerDao {

    @Getter
    private List<Engineer> engineers = new ArrayList<>(
            // Hardcoding list of engineers in code as of now.
            Arrays.asList(
                    new Engineer("1", "Sam"),
                    new Engineer("2", "John"),
                    new Engineer("3", "Peter"),
                    new Engineer("4", "Nurul"),
                    new Engineer("5", "Anna"),
                    new Engineer("6", "Amanda"),
                    new Engineer("7", "Jeffrey"),
                    new Engineer("8", "Cucu"),
                    new Engineer("9", "Haruun"),
                    new Engineer("10", "Shawn")
            )
    );
}
