package com.company.business.People.Worker;


import com.company.business.People.Human;
import com.company.business.Task.Technology;


import java.util.List;
import java.util.Objects;

public class Worker extends Human {

    private Double employmentCost;
    private Double maintenanceCost;
    private Double costOfDismissal;
    private Double workplaceCost;
    private Integer chanceToGetSick;
    private Integer riskOfCorrection;
    private Integer riskOfDelay;
    private List<Technology> listOfSkills;
    private WorkerRoleInCompany roleInCompany;

    public Worker(String name, String surname, Double money) {
        super(name, surname, money);
    }


    public void setEmploymentCost(Double employmentCost) {
        this.employmentCost = employmentCost;
    }

    public void setMaintenanceCost(Double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    public void setCostOfDismissal(Double costOfDismissal) {
        this.costOfDismissal = costOfDismissal;
    }

    public void setWorkplaceCost(Double workplaceCost) {
        this.workplaceCost = workplaceCost;
    }

    public void setChanceToGetSick(Integer chanceToGetSick) {
        this.chanceToGetSick = chanceToGetSick;
    }

    public void setRiskOfCorrection(Integer riskOfCorrection) {
        this.riskOfCorrection = riskOfCorrection;
    }

    public void setRiskOfDelay(Integer riskOfDelay) {
        this.riskOfDelay = riskOfDelay;
    }

    public Double getEmploymentCost() {
        return employmentCost;
    }

    public Double getMaintenanceCost() {
        return maintenanceCost;
    }

    public Double getCostOfDismissal() {
        return costOfDismissal;
    }

    public Double getWorkplaceCost() {
        return workplaceCost;
    }

    public Integer getChanceToGetSick() {
        return chanceToGetSick;
    }

    public Integer getRiskOfCorrection() {
        return riskOfCorrection;
    }

    public Integer getRiskOfDelay() {
        return riskOfDelay;
    }

    public List<Technology> getListOfSkills() {
        return listOfSkills;
    }

    public void setListOfSkills(List<Technology> listOfSkills) {
        this.listOfSkills = listOfSkills;
    }

    public WorkerRoleInCompany getRoleInCompany() {
        return roleInCompany;
    }

    public void setRoleInCompany(WorkerRoleInCompany roleInCompany) {
        this.roleInCompany = roleInCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return roleInCompany.equals(worker.roleInCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleInCompany);
    }
}
