package com.company.business.People.Worker;

import com.company.business.People.Human;
import com.company.business.Task.Technology;

import java.util.ArrayList;
import java.util.List;

public class Player extends Human {

    private List<Technology> listOfTechnology = new ArrayList<>();

    public Player(String name, String surname, Double money) {
        super(name, surname, money);

        this.listOfTechnology.add(new Technology("backend", 14));
        this.listOfTechnology.add(new Technology("dataBase", 4));
        this.listOfTechnology.add(new Technology("front-end", 5));
        this.listOfTechnology.add(new Technology("WordPress", 4));
        this.listOfTechnology.add(new Technology("PrestaShop", 4));
    }

    public List<Technology> getListOfTechnology() {
        return listOfTechnology;
    }


}




