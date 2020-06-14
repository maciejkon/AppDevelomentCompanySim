package com.company.business.company;

import com.company.business.People.Human;
import com.company.business.People.Worker.Player;
import com.company.business.People.Worker.Worker;
import com.company.business.People.Worker.WorkerMarket;
import com.company.business.Task.Project;
import com.company.business.Task.ProjectComplexity;
import com.company.business.Task.ProjectGenerator;
import com.company.business.Task.Technology;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company {
    private LocalDate now;
    WorkerMarket market = new WorkerMarket();
    private Player owner;
    private List<Worker> listOfWorkers = new ArrayList<>();
    private List<Project> listOfProjects = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    private Double money;

    public Company(Player owner) {
        this.now = LocalDate.of(2020, 01, 01);
        this.owner = owner;
        this.money = 10000.0;
    }

    public void addNewWorker() {
        List<Worker> randWork = market.getListOfWorkers();

        int number;
        System.out.println("Pracownicy do wyboru: ");
        for (int i = 0; i < randWork.size(); i++) {
            System.out.println(i + ". \n" + "Imie: " + randWork.get(i).getName() + "\n" + "Nazwisko: " + randWork.get(i).getSurname() + "\n" +
                    "Koszt zatrudnienia: " + randWork.get(i).getEmploymentCost() + "\n" + "Lista znanych technologii: " + randWork.get(i).getListOfSkills() + "\n");
        }
        System.out.println("Wybierz pracownika: ");
        number = in.nextInt();
        listOfWorkers.add(randWork.get(number));
        setMoney(getMoney() - randWork.get(number).getEmploymentCost());
        market.hireEmployer(randWork.get(number));
        System.out.println("Twoje pieniądze: " + getMoney());
        for (Worker worker : listOfWorkers) {
            System.out.println("Lista pracowników: \n" + worker.getName() + " " + worker.getSurname() + " " + worker.getEmploymentCost());
        }
    }

    public void fireWorker() {
        int number;
        System.out.println("Wybierz pracownika: ");
        for (int i = 0; i < listOfWorkers.size(); i++) {
            System.out.println(i + 1 + "\nImię: " + listOfWorkers.get(i).getName() + "\n" + "Nazwisko: " + listOfWorkers.get(i).getSurname() + "\nKoszt zwolnienia: " + listOfWorkers.get(i).getCostOfDismissal());
        }
        number = in.nextInt();
        market.addWorkerToTheMarket(listOfWorkers.get(number - 1));
        setMoney(getMoney() - listOfWorkers.get(number - 1).getCostOfDismissal());
        listOfWorkers.remove(number - 1);
    }

    public void addNewProject() {
        ProjectGenerator gen = new ProjectGenerator();
        List<Project> randWork = gen.generate(3);
        boolean choose = false;
        while (choose != true) {

            Integer number;
            for (int i = 0; i < randWork.size(); i++) {
                randWork.get(i).setTimeOfAddingProject(now);
                System.out.println(i + 1 + ". " + randWork.get(i).toString());
            }
            System.out.println("Wybierz project lub wciśnij 0 zeby wyjść: ");
            number = in.nextInt();

            if (number == 0) {
                break;
            }

            if (number - 1 >= randWork.size()) {
                System.out.println("Niepoprawna liczba, spróbuj ponownie!");
                continue;
            }

            Project selectedProject = randWork.get(number - 1);

            if (!getListOfSkillsInCompany().containsAll(selectedProject.getTechnologyInProjectList())) {
                System.out.println("<<Error>>: Nie umiesz technologii zawartych w tym projekcie, Spróbuj ponownie (wybierz inny projekt)!" + "\n------------------");
            } else if (listOfWorkers.isEmpty() && selectedProject.getLevelOfComplexity().equals(ProjectComplexity.HIGH)) {
                System.out.println("<<Error>>: Nie mając pracowników nie mozesz realizować projektów z wysoką złożonością> Spróbuj ponownie! " + "\n------------------");
            } else {
                listOfProjects.add(selectedProject);
                System.out.println("Twoje projekty: ");
                for (Project project : listOfProjects) {
                    System.out.println("------------------\n" + project.toString() + "\n------------------");
                    choose = true;
                }
            }

        }
    }

    public void workOnProjects() {
        int numberOfProject;
        for (int i = 0; i < listOfProjects.size(); i++) {
            System.out.println(i + ". " + listOfProjects.get(i).toString());
        }
        System.out.println("Wybierz project: ");
        numberOfProject = in.nextInt();

        Project selectedProject = listOfProjects.get(numberOfProject);
        selectedProject.addWorkerToTheProject(chooseWorkerInProject());
        selectedProject.workOneDay();
    }

    public void finishProject() {
        int number;
        for (int i = 0; i < listOfProjects.size(); i++) {
            if (listOfProjects.get(i).isProjectDone()) {
                System.out.println(i + ". " + listOfProjects.get(i).toString());
            }
        }
        System.out.println("Wybierz project: ");
        number = in.nextInt();

        Project selectedProject = listOfProjects.get(number);
        setMoney(getMoney() + selectedProject.getPriceOfProject());
        listOfProjects.remove(selectedProject);
        System.out.println("Ukończyłeś projekt: " + selectedProject);
    }

    public Human chooseWorkerInProject() {
        Integer number;
        List<Human> tempListOfAllWorkers = new ArrayList<>();
        tempListOfAllWorkers.add(owner);
        tempListOfAllWorkers.addAll(listOfWorkers);

        System.out.println("Wybierz pracownika do pracy przy tym projekcie: ");
        for (int i = 0; i < tempListOfAllWorkers.size(); i++) {
            System.out.println(i + 1 + ". " + tempListOfAllWorkers.get(i).toString());
        }
        number = in.nextInt();
        return tempListOfAllWorkers.get(number - 1);
    }

    public void newDay() {
        this.now = now.plusDays(1);
    }


    private List<Technology> getListOfSkillsInCompany() {
        List<Technology> listOfSkills = new ArrayList<>();

        listOfSkills.addAll(owner.getListOfTechnology());

        for (Worker worker : listOfWorkers) {
            listOfSkills.addAll(worker.getListOfSkills());
        }
        return listOfSkills;
    }


    public Double getMoney() {
        return money;
    }

    public List<Project> getListOfProjects() {
        return listOfProjects;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public List<Worker> getListOfWorkers() {
        return listOfWorkers;
    }

    public LocalDate getCurrentDate() {
        return now;
    }

    public void showActualInfo() {
        System.out.println("     Data: " + getCurrentDate());
        System.out.println("     Stan konta firmy: " + getMoney());
        System.out.println("     Postępy projektów: ");
        for (int i = 0; i < listOfProjects.size(); i++) {
            System.out.println("     " + i + 1 + ". " + listOfProjects.get(i).getTitleOfProject() + " Postęp (w dniach): " +
                    listOfProjects.get(i).getCurrentDaysOfWork() + "/" + listOfProjects.get(i).getRequiredDaysOfWork());
        }
    }

    public void showWelcomeInfo() {
        System.out.println();
        System.out.println("     **************************************");
        System.out.println("     *               APPSTORE             *");
        System.out.println("     **************************************");
        System.out.println("     Witaj: " + this.owner.getName() + " " + this.owner.getSurname());
        System.out.println("     Twoje umiejętności to: " + this.owner.getListOfTechnology());
        System.out.println("     Wybierz projekt początkowy!\n------------------");
    }


}

