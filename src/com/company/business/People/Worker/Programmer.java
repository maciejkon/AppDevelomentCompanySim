package com.company.business.People.Worker;

import com.company.business.Task.Technology;
import com.company.business.Task.TechnologyGenerator;

import java.util.List;

public class Programmer extends Worker {

    private int levelOfSkill;


    public Programmer(String name, String surname, Double money) {
        super(name, surname, money);

        setRoleInCompany(WorkerRoleInCompany.PROGRAMMER);
        TechnologyGenerator gen = new TechnologyGenerator();
        List<Technology> listOfSkills = gen.generate();
        setListOfSkills(listOfSkills);
        switch (listOfSkills.size()) {
            case 3:
                this.levelOfSkill = 3;
                setEmploymentCost(2000.0);
                setMaintenanceCost(200.0);
                setCostOfDismissal(4000.0);
                setWorkplaceCost(100.0);
                setChanceToGetSick(10);
                setRiskOfCorrection(0);
                setRiskOfDelay(0);
                break;
            case 2:
                this.levelOfSkill = 2;
                setEmploymentCost(1000.0);
                setMaintenanceCost(100.0);
                setCostOfDismissal(2000.0);
                setWorkplaceCost(80.0);
                setChanceToGetSick(20);
                setRiskOfCorrection(10);
                setRiskOfDelay(0);
                break;
            case 1:
                this.levelOfSkill = 1;
                setEmploymentCost(500.0);
                setMaintenanceCost(50.0);
                setCostOfDismissal(1000.0);
                setWorkplaceCost(50.0);
                setChanceToGetSick(30);
                setRiskOfCorrection(20);
                setRiskOfDelay(20);
                break;
        }

    }


    public int getLevelOfSkill() {
        return levelOfSkill;
    }
}
