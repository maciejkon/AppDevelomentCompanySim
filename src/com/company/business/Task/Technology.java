package com.company.business.Task;

import java.util.Objects;

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

    public Integer getLevelOfAdvancement() {
        return levelOfAdvancement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Technology that = (Technology) o;
        return nameOfTechnology.equals(that.nameOfTechnology);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfTechnology);
    }
}
