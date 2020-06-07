package com.company.People.Worker;

import com.company.People.Human;

import java.util.ArrayList;
import java.util.List;

public class Player extends Human {

    private List<Worker> listOfWorkers = new ArrayList<>();

    public Player(String name, String surname, Double money, String email) {
        super(name, surname, money, email);
    }

    public void startNewProject(){

    }


}




