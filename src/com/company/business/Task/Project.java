package com.company.business.Task;

import com.company.TechnologyGenerator;
import com.company.business.People.Customer.Customer;
import com.company.business.People.Customer.CustomerSelector;
import com.company.business.People.Worker.Worker;

import java.util.List;

public class Project {

    private String titleOfProject;
    private Integer numberOfDaysToFinish = 0;
    private Customer ownerOfTheProject;
    private String deadLine;
    private Double amountOfPenalty;
    private Double priceOfProject;
    private String dateOfPayment;
    private Boolean payOnAdvance;
    private ProjectComplexity levelOfComplexity;
    private List<Worker> listOfWorkersInProject;

    private List<Technology> technologyInProjectList;

    public Project(String titleOfProject, String deadLine, Double amountOfPenalty,
                   Double priceOfProject) {
        this.titleOfProject = titleOfProject;

        CustomerSelector selector = new CustomerSelector();
        this.ownerOfTheProject = selector.select();
        //this.deadLine=datadodaniaprojektu+ilość roboczogodzin w przeliczeniu na dni
        //this.dateOfPayment=deadline

        this.deadLine = deadLine;
        this.amountOfPenalty = amountOfPenalty;
        this.priceOfProject = priceOfProject;

        TechnologyGenerator gen = new TechnologyGenerator();
        this.technologyInProjectList = gen.generate();
        for (Technology technology : technologyInProjectList) {
            this.numberOfDaysToFinish += technology.getLevelOfAdvancement();
        }
        //poziom złożoności zależny od ilości technologii
        this.levelOfComplexity = ProjectComplexity.getComplexity(technologyInProjectList);
        //zaliczka zależna od poziomu złożoności
        if (levelOfComplexity == ProjectComplexity.LOW) {
            this.payOnAdvance = false;
        } else {
            this.payOnAdvance = true;
        }
    }

    @Override
    public String toString() {

        return "Nazwa projektu: " + titleOfProject + "\n" + "Termin skończenia projektu: "
                + deadLine + "\n" + "Cena projektu: " + priceOfProject + "\n" + "Poziom skomplikowania: "
                + levelOfComplexity + "\n" + "Właściciel projektu: " + ownerOfTheProject + "\n" + "Wymagane technologie: " +
                technologyInProjectList.toString() + "\n------------------";
    }

    public ProjectComplexity getLevelOfComplexity() {
        return levelOfComplexity;
    }


    public void setOwnerOfTheProject(Customer ownerOfTheProject) {
        this.ownerOfTheProject = ownerOfTheProject;
    }

    public List<Technology> getTechnologyInProjectList() {
        return technologyInProjectList;
    }


    public List<Worker> getListOfWorkersInProject() {
        return listOfWorkersInProject;
    }

    public void setListOfWorkersInProject(List<Worker> listOfWorkersInProject) {
        this.listOfWorkersInProject = listOfWorkersInProject;
    }
}
