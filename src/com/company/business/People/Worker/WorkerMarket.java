package com.company.business.People.Worker;

import java.util.ArrayList;
import java.util.List;

public class WorkerMarket {
    private List<Worker> listOfWorkers;
    private List<Subcontractor> listOfSubcontractors = new ArrayList<>();

    public WorkerMarket() {
        WorkerGenerator gen = new WorkerGenerator();
        this.listOfWorkers = gen.generate();

        listOfSubcontractors.add(new Subcontractor("Alex ", "Malinowski", 2000.0, 3));
        listOfSubcontractors.add(new Subcontractor("Bolesław", "Szulc", 1000.0, 2));
        listOfSubcontractors.add(new Subcontractor("Jerzy", "Górecki", 500.0, 1));
    }

    public List<Worker> addAnoucement() {
        List<Worker> newListOfWorkers;
        WorkerGenerator gen = new WorkerGenerator();
        newListOfWorkers = gen.generate();
        newListOfWorkers.addAll(getListOfWorkers());
        return newListOfWorkers;
    }

    public List<Worker> getListOfWorkers() {
        return listOfWorkers;
    }

    public List<Subcontractor> getListOfSubcontractors() {
        return listOfSubcontractors;
    }

    public void hireEmployer(Worker worker) {
        listOfWorkers.remove(worker);
    }

    public void addWorkerToTheMarket(Worker worker) {
        listOfWorkers.add(worker);
    }
}
