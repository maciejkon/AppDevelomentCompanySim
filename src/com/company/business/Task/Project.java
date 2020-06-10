package com.company.business.Task;

import com.company.TechnologyGenerator;
import com.company.business.People.Customer.Customer;
import com.company.business.People.Customer.CustomerSelector;

import java.util.List;

public class Project {
    private String titleOfProject;
    private String deadLine;
    private Double amountOfPenalty;
    private Double priceOfProject;
    private Customer ownerOfTheProject;
    private Boolean payOnAdvance;
    private List<Technology> technologyInProjectList;
    private ProjectComplexity levelOfComplexity;
    private Integer numberOfDaysToFinish = 0;

    public Project(String titleOfProject, String deadLine, Double amountOfPenalty,
                   Double priceOfProject) {
        CustomerSelector selector = new CustomerSelector();
        this.ownerOfTheProject = selector.select();
        this.titleOfProject = titleOfProject;
        this.deadLine = deadLine;
        this.amountOfPenalty = amountOfPenalty;
        this.priceOfProject = priceOfProject;
        TechnologyGenerator gen = new TechnologyGenerator();
        this.technologyInProjectList = gen.generate();
        for (Technology technology : technologyInProjectList) {
            this.numberOfDaysToFinish += technology.getLevelOfAdvancement();
        }
        this.levelOfComplexity = ProjectComplexity.getComplexity(technologyInProjectList);
    }

    @Override
    public String toString() {

        return "Nazwa projektu: " + titleOfProject + "\n" + "Termin skończenia projektu: "
                + deadLine + "\n" + "Cena projektu: " + priceOfProject + "\n" + "Poziom skomplikowania: " + levelOfComplexity + "\n------------------";
    }

    public ProjectComplexity getLevelOfComplexity() {
        return levelOfComplexity;
    }

    public void setOwnerOfTheProject(Customer ownerOfTheProject) {
        this.ownerOfTheProject = ownerOfTheProject;
    }
}
