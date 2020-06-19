package com.company.business.Task;

import com.company.business.People.Customer.Customer;
import com.company.business.People.Customer.CustomerSelector;
import com.company.business.People.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {

    private String titleOfProject;
    private Customer ownerOfTheProject;

    private LocalDate timeOfAddingProject;
    private LocalDate dateOfPayment;
    private LocalDate deadLine;
    private int requiredDaysOfWork;
    private int currentDaysOfWork = 0;

    private Double amountOfPenalty;
    private Double priceOfProject;
    private Boolean payOnAdvance;
    private Boolean wasTested = false;
    private Boolean wasTestedByOwner = false;
    private Boolean getBySeller = false;
    private ProjectComplexity levelOfComplexity;
    private List<Human> listOfWorkersInProject = new ArrayList<>();

    private List<Technology> technologyInProjectList;

    public Project(String titleOfProject, Double amountOfPenalty,
                   Double priceOfProject, LocalDate deadLine) {
        this.titleOfProject = titleOfProject;

        CustomerSelector selector = new CustomerSelector();
        this.ownerOfTheProject = selector.select();

        this.amountOfPenalty = amountOfPenalty;
        this.priceOfProject = priceOfProject;

        TechnologyGenerator gen = new TechnologyGenerator();
        this.technologyInProjectList = gen.generate();

        this.levelOfComplexity = ProjectComplexity.getComplexity(technologyInProjectList);

        if (levelOfComplexity == ProjectComplexity.LOW) {
            this.payOnAdvance = false;
        } else {
            this.payOnAdvance = true;
        }
        this.requiredDaysOfWork = countDaysToFinish();

        this.deadLine = deadLine;
        this.dateOfPayment = deadLine.plusDays(7);

    }

    @Override
    public String toString() {

        return "\nNazwa projektu: " + titleOfProject + "\n"
                + "Zapłata za projekt: "
                + priceOfProject + " zł" + "\n" + "Data oddania projektu: "
                + deadLine + "\n" + "Przewidywana data skończenia projektu (jeśli pracujesz nad nim codziennie) "
                + timeOfAddingProject.plusDays(requiredDaysOfWork + 1) + "\n" + "Poziom skomplikowania: "
                + levelOfComplexity + "\n" + "Właściciel projektu: "
                + ownerOfTheProject + "\n" + "Wymagane technologie: "
                + technologyInProjectList.toString() + getBySeller + "\n------------------";
    }

    public int countDaysToFinish() {
        int days = 0;
        for (int i = 0; i < technologyInProjectList.size(); i++) {
            days += technologyInProjectList.get(i).getLevelOfAdvancement();
        }
        return days;
    }

    public boolean isProjectDone() {
        if (requiredDaysOfWork == currentDaysOfWork) {
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


    public List<Human> getListOfWorkersInProject() {
        return listOfWorkersInProject;
    }

    public void addWorkerToTheProject(Human human) {
        this.listOfWorkersInProject.add(human);
    }

    public Double getPriceOfProject() {
        return priceOfProject;
    }

    public void setPriceOfProject(Double priceOfProject) {
        this.priceOfProject = priceOfProject;
    }

    public void workOneDay() {
        this.currentDaysOfWork += 1;
    }

    public void setTimeOfAddingProject(LocalDate timeOfAddingProject) {
        this.timeOfAddingProject = timeOfAddingProject;
    }

    public String getTitleOfProject() {
        return titleOfProject;
    }

    public int getCurrentDaysOfWork() {
        return currentDaysOfWork;
    }

    public int getRequiredDaysOfWork() {
        return requiredDaysOfWork;
    }


    public Boolean getWasTested() {
        return wasTested;
    }

    public void setWasTested(Boolean wasTested) {
        this.wasTested = wasTested;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public Boolean getGetBySeller() {
        return getBySeller;
    }

    public void setGetBySeller(Boolean getBySeller) {
        this.getBySeller = getBySeller;
    }

    public Boolean getWasTestedByOwner() {
        return wasTestedByOwner;
    }

    public void setWasTestedByOwner(Boolean wasTestedByOwner) {
        this.wasTestedByOwner = wasTestedByOwner;
    }

    public void setDateOfPayment(LocalDate dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public Double getAmountOfPenalty() {
        return amountOfPenalty;
    }

    public Customer getOwnerOfTheProject() {
        return ownerOfTheProject;
    }
}
