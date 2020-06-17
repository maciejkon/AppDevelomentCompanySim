package com.company.business.company;

import com.company.business.People.Human;
import com.company.business.People.Worker.Player;
import com.company.business.People.Worker.Worker;
import com.company.business.People.Worker.WorkerMarket;
import com.company.business.People.Worker.WorkerRoleInCompany;
import com.company.business.Task.Project;
import com.company.business.Task.ProjectComplexity;
import com.company.business.Task.ProjectGenerator;
import com.company.business.Task.Technology;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company {
    static Scanner in = new Scanner(System.in);
    WorkerMarket market = new WorkerMarket();
    private List<Worker> listOfWorkers = new ArrayList<>();
    private List<Project> listOfProjects = new ArrayList<>();

    private LocalDate now;
    private Player owner;
    private Integer currentDaysOfLookingForNewClient = 0;
    private Integer currentDaysOfBookkeeping = 0;
    private Double money;

    public Company(Player owner) {
        this.now = LocalDate.of(2020, 01, 01);
        this.owner = owner;
        this.money = 10000.0;
    }

    public void addNewProject() {
        ProjectGenerator gen = new ProjectGenerator();
        List<Project> randProj = gen.generate(3);
        boolean choose = false;
        while (choose != true) {
            if (this.currentDaysOfLookingForNewClient >= 5) {
                int numberOfProjects = currentDaysOfLookingForNewClient / 5;
                List<Project> randProjAfterSearching = gen.generate(numberOfProjects);
                randProj.addAll(randProjAfterSearching);
                currentDaysOfLookingForNewClient -= numberOfProjects * 5;
                System.out.println("Dodano: " + randProjAfterSearching.size());
            }
            Integer number;
            for (int i = 0; i < randProj.size(); i++) {
                randProj.get(i).setTimeOfAddingProject(now);
                System.out.println(i + 1 + ". " + randProj.get(i).toString());
            }
            System.out.println("Wybierz project lub wciśnij 0 zeby wyjść: ");
            number = in.nextInt();

            if (number == 0) {
                break;
            }
            if (!numberChecker(number, randProj)) {
                System.out.println("Niepoprawna liczba, spróbuj ponownie!");
                continue;
            }
            Project selectedProject = randProj.get(number - 1);

            if (!getListOfSkillsInCompany().containsAll(selectedProject.getTechnologyInProjectList())) {
                System.out.println("<<Error>>: Nie umiesz technologii zawartych w tym projekcie, Spróbuj ponownie (wybierz inny projekt)!" + "\n------------------");
            } else if (listOfWorkers.isEmpty() && selectedProject.getLevelOfComplexity().equals(ProjectComplexity.HIGH)) {
                System.out.println("<<Error>>: Nie mając pracowników nie mozesz realizować projektów z wysoką złożonością> Spróbuj ponownie! " + "\n------------------");
            } else {
                if (selectedProject.getLevelOfComplexity().equals(ProjectComplexity.HIGH)) {
                    System.out.println("Projekt ma wysoką złożoność! Nastąpi płatność zaliczki w wysokości 20% ceny projektu ");
                    setMoney(getMoney() + (selectedProject.getPriceOfProject() * 0.2));
                    selectedProject.setPriceOfProject(selectedProject.getPriceOfProject() - (selectedProject.getPriceOfProject() * 0.2));
                    System.out.println("Na twoje konto wpłyneło: " + selectedProject.getPriceOfProject() * 0.2 + " zł");
                } else if (!listOfProjects.isEmpty()) {
                    newDay();
                }
                listOfProjects.add(selectedProject);
                System.out.println("Twoje projekty: ");
                for (Project project : listOfProjects) {
                    System.out.println("------------------\n" + project.toString() + "\n------------------");
                    choose = true;
                }
            }

        }
    }

    public void lookForNewClient() {
        boolean choose = false;
        while (choose != true) {
            Integer number;

            if (listOfWorkers.isEmpty()) {
                System.out.println("ERROR: By wykonać tą czynność potrzebujesz pracowników");
                break;
            }
            boolean sellerFlag = false;
            for (int i = 0; i < listOfWorkers.size(); i++) {
                if (listOfWorkers.get(i).getRoleInCompany().equals(WorkerRoleInCompany.SELLER)) {
                    this.currentDaysOfLookingForNewClient++;
                    System.out.println("Dzień poświęcony na szukanie klientów");
                    newDay();
                    sellerFlag = true;
                    choose = true;
                }
            }
            if (!sellerFlag) {
                System.out.println("ERROR: Musisz mieć sprzedawcę!");
            }
            if (this.currentDaysOfLookingForNewClient >= 5) {
                System.out.println("Znalazłeś nowych klientów, sprawdź listę projektów!");
            }

            System.out.println("\nNaciśnij 0 żeby wyjść do menu!");
            number = in.nextInt();
            if (number == 0) {
                break;
            }
        }

    }

    public void workOnProjects() {

        boolean choose = false;
        while (choose != true) {
            int numberOfProject;
            for (int i = 0; i < listOfProjects.size(); i++) {
                System.out.println(i + 1 + ". " + listOfProjects.get(i).toString());
            }
            System.out.println("Wybierz project lub wciśnij 0 żeby wyjść: ");
            numberOfProject = in.nextInt();
            if (numberOfProject == 0) {
                break;
            }
            if (!numberChecker(numberOfProject, listOfProjects)) {
                System.out.println("Niepoprawna liczba, spróbuj ponownie!");
                continue;
            }
            Project selectedProject = listOfProjects.get(numberOfProject - 1);
            if (selectedProject.getCurrentDaysOfWork() == selectedProject.getRequiredDaysOfWork()) {
                System.out.println("UWAGA!! Ten projekt jest gotowy do oddania ");
                choose = true;
            } else {
                if (selectedProject.getListOfWorkersInProject().isEmpty()) {
                    selectedProject.addWorkerToTheProject(chooseWorkerInProject());
                }
                selectedProject.workOneDay();
                newDay();
                choose = true;
            }
        }
    }

    public void testCode() {
        boolean choose = false;
        while (choose != true) {
            int numberOfProject;
            for (int i = 0; i < listOfProjects.size(); i++) {
                System.out.println(i + 1 + ". " + listOfProjects.get(i).toString());
            }
            System.out.println("Wybierz project lub wciśnij 0 żeby wyjść: ");
            numberOfProject = in.nextInt();
            if (numberOfProject == 0) {
                break;
            }
            if (!numberChecker(numberOfProject, listOfProjects)) {
                System.out.println("Niepoprawna liczba, spróbuj ponownie!");
                continue;
            }
            Project selectedProject = listOfProjects.get(numberOfProject - 1);
            selectedProject.setWasTested(true);
            System.out.println("Kod został przetestowany");
            choose = true;
        }

    }

    public void finishProject() {
        int number;
        boolean choose = false;
        while (choose != true) {
            for (int i = 0; i < listOfProjects.size(); i++) {
                if (listOfProjects.get(i).isProjectDone()) {
                    System.out.println(i + 1 + ". " + listOfProjects.get(i).toString());
                } else {
                    System.out.println("Żaden projekt nie jest gotowy do oddania");
                }
            }
            System.out.println("Wybierz projekt lub wciśnij 0 żeby wyjść: ");
            number = in.nextInt();
            if (number == 0) {
                break;
            }
            if (!numberChecker(number, listOfProjects)) {
                System.out.println("Niepoprawna liczba, spróbuj ponownie!");
                continue;
            } else {
                Project selectedProject = listOfProjects.get(number - 1);

                setMoney(getMoney() + selectedProject.getPriceOfProject());
                listOfProjects.remove(selectedProject);
                System.out.println("Ukończyłeś projekt: " + selectedProject);
                newDay();
                choose = true;
            }

        }


    }

    public void addNewWorker() {
        List<Worker> randWork = market.getListOfWorkers();

        int number;
        boolean choose = false;
        while (choose != true) {
            System.out.println("Pracownicy do wyboru: ");
            for (int i = 0; i < randWork.size(); i++) {
                System.out.println(i + 1 + ". \n" + "Imie: " + randWork.get(i).getName() + "\n" + "Nazwisko: " + randWork.get(i).getSurname() + "\n" +
                        "Koszt zatrudnienia: " + randWork.get(i).getEmploymentCost() + "\n" + "Lista znanych technologii: " + randWork.get(i).getListOfSkills() + "\n" + "Stanowisko: " + randWork.get(i).getRoleInCompany());
            }
            System.out.println("Wybierz pracownika lub wciśnij 0 zeby wyjść: ");
            number = in.nextInt();

            if (number == 0) {
                break;
            }
            if (!numberChecker(number, randWork)) {
                System.out.println("Niepoprawna liczba, spróbuj ponownie!");
                continue;
            }
            listOfWorkers.add(randWork.get(number - 1));
            setMoney(getMoney() - randWork.get(number - 1).getEmploymentCost());
            market.hireEmployer(randWork.get(number - 1));
            System.out.println("Twoje pieniądze: " + getMoney());
            newDay();
            for (Worker worker : listOfWorkers) {
                System.out.println("Lista pracowników: \n" + worker.getName() + " " + worker.getSurname() + " " + worker.getEmploymentCost());
                choose = true;
            }
        }

    }

    public void fireWorker() {
        int number;
        boolean choose = false;
        while (choose != true) {

            System.out.println("Wybierz pracownika lub naciśnij 0 żeby wyjść: ");
            for (int i = 0; i < listOfWorkers.size(); i++) {
                System.out.println(i + 1 + "\nImię: " + listOfWorkers.get(i).getName() + "\n" + "Nazwisko: " + listOfWorkers.get(i).getSurname() + "\nKoszt zwolnienia: " + listOfWorkers.get(i).getCostOfDismissal());
            }
            number = in.nextInt();
            if (number == 0) {
                break;
            }
            if (!numberChecker(number, listOfWorkers)) {
                System.out.println("Niepoprawna liczba, spróbuj ponownie!");
                continue;
            }
            market.addWorkerToTheMarket(listOfWorkers.get(number - 1));
            setMoney(getMoney() - listOfWorkers.get(number - 1).getCostOfDismissal());
            listOfWorkers.remove(number - 1);
            newDay();
            choose = true;
        }

    }

    public void bookkeeping() {
        boolean choose = false;
        while (choose != true) {
            Integer number;
            this.currentDaysOfBookkeeping++;
            System.out.println("Spędziłeś dzien na rozliczaniu się. Wymagana ilość dni w miesiącu: " + currentDaysOfBookkeeping + "/" + 2);

            System.out.println("\nNaciśnij 0 żeby wyjść do menu!");
            number = in.nextInt();
            if (number == 0) {
                break;
            }
        }
    }


    public Human chooseWorkerInProject() {
        Integer number;
        List<Human> tempListOfAllWorkers = new ArrayList<>();
        if (now.getDayOfWeek().equals(DayOfWeek.SATURDAY) || now.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            System.out.println("Weekend: Tylko właściciel może dzisiaj pracować\n");
            tempListOfAllWorkers.add(owner);
        } else {
            System.out.println("Dzień roboczy: możesz wybrać właściciela lub pracownika\n");
            tempListOfAllWorkers.add(owner);
            tempListOfAllWorkers.addAll(listOfWorkers);
        }
        System.out.println("Wybierz kto ma pracować przy tym projekcie: ");
        for (int i = 0; i < tempListOfAllWorkers.size(); i++) {
            System.out.println(i + 1 + ". " + tempListOfAllWorkers.get(i).toString());
        }
        number = in.nextInt();
        return tempListOfAllWorkers.get(number - 1);
    }

    private List<Technology> getListOfSkillsInCompany() {
        List<Technology> listOfSkills = new ArrayList<>();

        listOfSkills.addAll(owner.getListOfTechnology());

        for (Worker worker : listOfWorkers) {
            listOfSkills.addAll(worker.getListOfSkills());
        }
        return listOfSkills;
    }

    public void showActualInfo() {
        System.out.println("     Data: " + getCurrentDate() + "\n     Dzień tygodnia: " + getCurrentDate().getDayOfWeek());
        System.out.println("     Stan konta firmy: " + getMoney());
        System.out.println("     Dostępni pracownicy: ");
        if (listOfWorkers.isEmpty()) {
            System.out.println("     Jesteś jedynym pracownikiem tej firmy");
        } else {
            for (Worker worker : listOfWorkers) {
                System.out.println("     " + worker.getName() + " " + worker.getSurname() + " " + worker.getRoleInCompany());
            }
        }

        if (listOfProjects.isEmpty()) {
            System.out.println("     Obecnie nie pracujesz nad żadnym projektem. Dodaj nowy!");
        } else {
            System.out.println("     Postępy projektów: ");
            for (int i = 0; i < listOfProjects.size(); i++) {
                System.out.println("     " + i + 1 + ". " + listOfProjects.get(i).getTitleOfProject() + " Postęp (w dniach): " +
                        listOfProjects.get(i).getCurrentDaysOfWork() + "/" + listOfProjects.get(i).getRequiredDaysOfWork());
            }
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

    public boolean numberChecker(Integer number, List list) {
        boolean status = true;


        if (number - 1 >= list.size()) {
            status = false;
        }


        return status;

    }

    public void newDay() {
        this.now = now.plusDays(1);
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
}

