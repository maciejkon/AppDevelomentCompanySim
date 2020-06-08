package com.company.business.People.Worker;

import com.company.WorkerGenerator;
import com.company.business.People.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends Human {
    static Scanner in = new Scanner(System.in);
    private List<Worker> listOfWorkers = new ArrayList<>();

    public Player(String name, String surname, Double money, String email) {
        super(name, surname, money, email);
    }

    public void addNewWorker() {
        WorkerGenerator gen = new WorkerGenerator();
        List<Worker> randWork = gen.generate();
        int number;
        for (int i = 0; i < randWork.size(); i++) {
            System.out.println(i + ". " + randWork.get(i).getEmploymentCost());
        }
        System.out.println("Wybierz pracownika: ");
        number = in.nextInt();
        listOfWorkers.add(randWork.get(number));
        System.out.println("Lista pracowników: " + listOfWorkers.get(number).getEmploymentCost());

    }


}




