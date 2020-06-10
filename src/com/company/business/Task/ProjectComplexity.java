package com.company.business.Task;

import java.util.List;

public enum ProjectComplexity {
    LOW, MEDIUM, HIGH;

    static public ProjectComplexity getComplexity(List<Technology> technologyList) {
        if (technologyList.size() == 1) {
            return LOW;
        }
        if (technologyList.size() == 2) {
            return MEDIUM;
        } else
            return HIGH;
    }

}
