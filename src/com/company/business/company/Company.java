package com.company.business.company;

import com.company.ProjectGenerator;
import com.company.WorkerGenerator;
import com.company.business.People.Worker.Player;
import com.company.business.People.Worker.Worker;
import com.company.business.Task.Project;
import com.company.business.Task.ProjectComplexity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company {
    private Player owner;
    private List<Worker> listOfWorkers = new ArrayList<>();
    private List<Project> listOfProjects = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    private Double money;

    public Company(Player owner) {
        this.owner = owner;
        this.money = 1000.0;
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
        for (Worker worker : listOfWorkers) {
            System.out.println("Lista pracowników: \n" + worker.getName() + " " + worker.getSurname() + " " + worker.getEmploymentCost());
        }
    }

    public void addNewProject() {
        ProjectGenerator gen = new ProjectGenerator();
        List<Project> randWork = gen.generate(4);
        int number;
        System.out.println("Wybierz projekt początkowy!\n------------------");
        for (int i = 0; i < randWork.size(); i++) {
            System.out.println(i + ". " + randWork.get(i).toString());
        }
        System.out.println("Wybierz project: ");
        number = in.nextInt();
        Project selectedProject = randWork.get(number);
        if (listOfWorkers.isEmpty() && !selectedProject.getLevelOfComplexity().equals(ProjectComplexity.HIGH)) {
            listOfProjects.add(randWork.get(number));
            for (Project project : listOfProjects) {
                System.out.println("Lista projektów: \n" + project.toString());
            }
        }
        System.out.println("Wybierz jeszcze raz ");

    }


    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public List<Worker> getListOfWorkers() {
        return listOfWorkers;
    }
}
