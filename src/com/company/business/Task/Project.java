package com.company.business.Task;

import com.company.business.People.Customer.Customer;
import com.company.business.People.Customer.CustomerSelector;
import com.company.business.People.Worker.Worker;

import java.time.LocalDate;
import java.util.List;

public class Project {

    private String titleOfProject;
    private Customer ownerOfTheProject;

    private LocalDate timeOfAddingProject = LocalDate.now();
    private LocalDate dateOfPayment;
    private LocalDate deadLine;
    private int requiareDaysOfWork;
    private int curretDaysOfWork = 0;

    private Double amountOfPenalty;
    private Double priceOfProject;
    private Boolean payOnAdvance;
    private ProjectComplexity levelOfComplexity;
    private List<Worker> listOfWorkersInProject;

    private List<Technology> technologyInProjectList;

    public Project(String titleOfProject, Double amountOfPenalty,
                   Double priceOfProject) {
        this.titleOfProject = titleOfProject;

        CustomerSelector selector = new CustomerSelector();
        this.ownerOfTheProject = selector.select();

        this.amountOfPenalty = amountOfPenalty;
        this.priceOfProject = priceOfProject;

        TechnologyGenerator gen = new TechnologyGenerator();
        this.technologyInProjectList = gen.generate();

        //poziom złożoności zależny od ilości technologii
        this.levelOfComplexity = ProjectComplexity.getComplexity(technologyInProjectList);
        //zaliczka zależna od poziomu złożoności
        if (levelOfComplexity == ProjectComplexity.LOW) {
            this.payOnAdvance = false;
        } else {
            this.payOnAdvance = true;
        }
        this.requiareDaysOfWork = countDaysToFinish();

        /*this.deadLine =this.timeOfAddingProject.plusDays(countDaysToFinish());
        this.dateOfPayment=this.deadLine.plusDays(7);*/

    }

    @Override
    public String toString() {

        return "\nNazwa projektu: " + titleOfProject + "\n"
                + "Zapłata za projekt: " + priceOfProject + " zł" + "\n" + "Data oddania projektu: " + deadLine + "\n" + "Data otrzymania zapłaty: " + dateOfPayment + "\n" + "Poziom skomplikowania: "
                + levelOfComplexity + "\n" + "Właściciel projektu: " + ownerOfTheProject + "\n" + "Wymagane technologie: " +
                technologyInProjectList.toString() + "\n------------------";
    }

    public int countDaysToFinish() {
        int days = 0;
        for (int i = 0; i < technologyInProjectList.size(); i++) {
            days += technologyInProjectList.get(i).getLevelOfAdvancement();
        }
        return days;
    }

    public boolean isProjectDone() {
        if (requiareDaysOfWork == curretDaysOfWork) {
            return true;
        }
        return false;
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

    public void setListOfWorkersInProject(Worker worker) {
        this.listOfWorkersInProject.add(worker);
    }

    public Double getPriceOfProject() {
        return priceOfProject;
    }

    public void workOneDay() {
        this.curretDaysOfWork += 1;
    }
}
