package com.company.business.People.Worker;

import com.company.business.Task.Technology;
import com.company.business.Task.TechnologyGenerator;

import java.util.List;

public class Subcontractor extends Programmer {
    private List<Technology> listOfSkills;
    private int levelOfSkill;

    public Subcontractor(String name, String surname, Double money, int levelOfSkill) {
        super(name, surname, money);
        this.levelOfSkill = levelOfSkill;

        TechnologyGenerator gen = new TechnologyGenerator();
        this.listOfSkills = gen.generate();

        switch (this.levelOfSkill) {
            case 3:
                setEmploymentCost(1000.0);
                setRiskOfCorrection(0.0);
                setRiskOfDelay(0.0);
                break;
            case 2:
                setEmploymentCost(500.0);
                setRiskOfCorrection(0.1);
                setRiskOfDelay(0.0);
                break;
            case 1:
                setEmploymentCost(250.0);
                setRiskOfCorrection(0.2);
                setRiskOfDelay(0.2);
                break;
        }


    }
}
