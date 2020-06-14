package com.company.business.People.Worker;

import com.company.business.People.Human;
import com.company.business.Task.Technology;

import java.util.ArrayList;
import java.util.List;

public class Player extends Human {

    private List<Technology> listOfTechnology = new ArrayList<>();

    public Player(String name, String surname) {
        super(name, surname, 100.0);

        this.listOfTechnology.add(new Technology("backend", 7));
        this.listOfTechnology.add(new Technology("dataBase", 2));
        this.listOfTechnology.add(new Technology("front-end", 3));
        this.listOfTechnology.add(new Technology("WordPress", 2));
        this.listOfTechnology.add(new Technology("PrestaShop", 2));
    }

    public List<Technology> getListOfTechnology() {
        return listOfTechnology;
    }


}




