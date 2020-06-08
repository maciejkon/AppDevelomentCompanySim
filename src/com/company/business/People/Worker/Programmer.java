package com.company.business.People.Worker;

import com.company.TechnologyGenerator;
import com.company.business.Task.Technology;

import java.util.List;

public class Programmer extends Worker {

    private List<Technology> listOfSkills;
    private int levelOfSkill;


    public Programmer(String name, String surname, Double money, String email) {
        super(name, surname, money, email);

        TechnologyGenerator gen = new TechnologyGenerator();
        this.listOfSkills = gen.generate();
        switch (this.listOfSkills.size()) {
            case 3:
                this.levelOfSkill = 3;
                setEmploymentCost(2000.0);
                setMaintenanceCost(200.0);
                setCostOfDismissal(4000.0);
                setWorkplaceCost(100.0);
                setChanceToGetSick(0.1);
                setRiskOfCorrection(0.0);
                setRiskOfDelay(0.0);
                break;
            case 2:
                this.levelOfSkill = 2;
                setEmploymentCost(1000.0);
                setMaintenanceCost(100.0);
                setCostOfDismissal(2000.0);
                setWorkplaceCost(80.0);
                setChanceToGetSick(0.2);
                setRiskOfCorrection(0.1);
                setRiskOfDelay(0.0);
                break;
            case 1:
                this.levelOfSkill = 1;
                setEmploymentCost(500.0);
                setMaintenanceCost(50.0);
                setCostOfDismissal(1000.0);
                setWorkplaceCost(50.0);
                setChanceToGetSick(0.3);
                setRiskOfCorrection(0.2);
                setRiskOfDelay(0.2);
                break;
        }

    }

    public List<Technology> getListOfSkills() {
        return listOfSkills;
    }

    public int getLevelOfSkill() {
        return levelOfSkill;
    }
}
