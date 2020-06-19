package com.company.business.People.Worker;

import com.company.business.Task.Technology;

import java.util.ArrayList;
import java.util.List;

public class Tester extends Worker {


    public Tester(String name, String surname, Double money) {
        super(name, surname, money);
        setRoleInCompany(WorkerRoleInCompany.TESTER);
        setEmploymentCost(1000.0);
        setMaintenanceCost(50.0);
        setCostOfDismissal(1000.0);
        setWorkplaceCost(10.0);
        List<Technology> listOfSkills = new ArrayList<>();
        listOfSkills.add(new Technology("Testowanie", 1));
        setListOfSkills(listOfSkills);
    }
}
