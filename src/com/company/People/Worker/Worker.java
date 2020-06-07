package com.company.People.Worker;


import com.company.People.Human;

public class Worker extends Human {

    private Double employmentCost;
    private Double maintenanceCost;
    private Double costOfDismissal;
    private Double workplaceCost;

    public Worker(String name, String surname, Double money, String email,
                  Double employmentCost,Double maintenanceCost,Double costOfDismissal, Double workplaceCost) {
        super(name, surname, money, email);

        this.employmentCost=employmentCost;
        this.maintenanceCost=maintenanceCost;
        this.costOfDismissal=costOfDismissal;
        this.workplaceCost=workplaceCost;
    }
}
