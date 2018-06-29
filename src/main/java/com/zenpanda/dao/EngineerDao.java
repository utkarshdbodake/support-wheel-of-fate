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
            Arrays.asList(
                    new Engineer("1", "Utkarsh 1"),
                    new Engineer("2", "Utkarsh 2"),
                    new Engineer("3", "Utkarsh 3"),
                    new Engineer("4", "Utkarsh 4"),
                    new Engineer("5", "Utkarsh 5"),
                    new Engineer("6", "Utkarsh 6"),
                    new Engineer("7", "Utkarsh 7"),
                    new Engineer("8", "Utkarsh 8"),
                    new Engineer("9", "Utkarsh 9"),
                    new Engineer("10", "Utkarsh 10")
            )
    );
}
