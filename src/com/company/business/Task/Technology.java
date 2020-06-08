package com.company.business.Task;

public class Technology {
    private String nameOfTechnology;
    private Integer levelOfAdvancement;


    public Technology(String nameOfTechnology, Integer levelOfAdvancement) {
        this.nameOfTechnology = nameOfTechnology;
        this.levelOfAdvancement = levelOfAdvancement;
    }

    public String getNameOfTechnology() {
        return nameOfTechnology;
    }

    @Override
    public String toString() {
        return nameOfTechnology;
    }
}
