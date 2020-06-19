package com.company.business.People.Worker;

import com.company.business.Task.Technology;

import java.util.ArrayList;
import java.util.List;

public class Seller extends Worker {

    public Seller(String name, String surname, Double money) {
        super(name, surname, money);
        setRoleInCompany(WorkerRoleInCompany.SELLER);
        setEmploymentCost(1000.0);
        setMaintenanceCost(50.0);
        setCostOfDismissal(1000.0);
        setWorkplaceCost(10.0);
        List<Technology> listOfSkills = new ArrayList<>();
        listOfSkills.add(new Technology("Sprzedawanie", 1));
        setListOfSkills(listOfSkills);
    }

}
