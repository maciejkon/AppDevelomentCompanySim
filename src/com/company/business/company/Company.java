package com.company.business.company;

import com.company.business.People.Human;
import com.company.business.People.Worker.*;
import com.company.business.Task.Project;
import com.company.business.Task.ProjectComplexity;
import com.company.business.Task.ProjectGenerator;
import com.company.business.Task.Technology;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Company {
    static Scanner in = new Scanner(System.in);
    WorkerMarket market = new WorkerMarket();
    private List<Worker> listOfWorkers = new ArrayList<>();
    private List<Project> listOfProjects = new ArrayList<>();
    private List<Project> listOfDoneProjects = new ArrayList<>();

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
            Integer number;
            if (this.currentDaysOfLookingForNewClient >= 5) {
                int numberOfProjects = currentDaysOfLookingForNewClient / 5;
                List<Project> randProjAfterSearching = gen.generate(numberOfProjects);
                for (Project project : randProjAfterSearching) {
                    project.setGetBySeller(true);
                }
                randProj.addAll(randProjAfterSearching);
                currentDaysOfLookingForNewClient -= numberOfProjects * 5;
                System.out.println("Dodano: " + randProjAfterSearching.size());
            }
            for (int i = 0; i < randProj.size(); i++) {
                randProj.get(i).setTimeOfAddingProject(now);
                randProj.get(i).setDeadLine(now.plusDays(15));
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
                    System.out.println("Dzień poświęcony na szukanie klientów. Liczba dnia ogółem: " + currentDaysOfLookingForNewClient);
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
            } else {
                int number;
                if (selectedProject.getListOfWorkersInProject().isEmpty()) {
                    System.out.println("Wybierz kogo wybierasz do pracy przy projekcie: ");
                    if (getCurrentDate().getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
                            getCurrentDate().getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                        System.out.println("Jest weekend, więc pracować możesz tylko ty!\n");
                        System.out.println("1.Właściciel");
                    } else {
                        System.out.println("1.Właściciel\n2.Pracownicy\n3.Podwykonawcy");
                    }
                    number = in.nextInt();

                    switch (number) {
                        case 1:
                            selectedProject.addWorkerToTheProject(owner);
                            break;
                        case 2:
                            for (int i = 0; i < listOfWorkers.size(); i++) {
                                System.out.println(i + 1 + ". " + listOfWorkers.get(i).toString());
                            }
                            int numberOfWorker;
                            System.out.println("Wybierz pracownika: ");
                            numberOfWorker = in.nextInt();

                            if (!numberChecker(numberOfWorker, listOfWorkers)) {
                                System.out.println("Niepoprawna liczba, spróbuj ponownie!");
                                continue;
                            }

                            Human selectedWorker = listOfWorkers.get(numberOfWorker - 1);
                            selectedProject.addWorkerToTheProject(selectedWorker);
                            break;
                        case 3:
                            WorkerMarket market = new WorkerMarket();
                            List<Human> listOfSubcontractors = market.getListOfSubcontractors();

                            for (int i = 0; i < listOfSubcontractors.size(); i++) {
                                System.out.println(i + 1 + ". " + listOfSubcontractors.get(i).toString());
                            }
                            int numberOfSubcontractor;
                            System.out.println("Wybierz podwykonawce: ");
                            numberOfSubcontractor = in.nextInt();

                            Human selectedSubcontractor = listOfSubcontractors.get(numberOfSubcontractor - 1);
                            setMoney(getMoney() - selectedSubcontractor.getMoney());
                            selectedSubcontractor.setMoney(getMoney());
                            selectedProject.addWorkerToTheProject(selectedSubcontractor);
                            break;
                    }
                }
                selectedProject.workOneDay();
                newDay();
            }
            choose = true;
        }
    }

    public void testCode() {
        boolean choose = false;
        while (choose != true) {
            for (int i = 0; i < listOfWorkers.size(); i++) {
                if (listOfWorkers.get(i).getRoleInCompany().equals(WorkerRoleInCompany.TESTER)) {
                    System.out.println("Nie musisz testować samodzielnie jeśli w drużynie masz testera");
                    for (Project project : listOfProjects) {
                        project.setWasTested(true);
                        choose = true;
                    }
                }
            }
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
            selectedProject.setWasTestedByOwner(true);
            System.out.println("SUCCESS: Kod został przetestowany");
            newDay();
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
                if (!selectedProject.getWasTested()) {
                    if (isChanceHappendWith(selectedProject.getOwnerOfTheProject().getChanceOfLosingTheContract())) {
                        System.out.println("Oddałeś niedziałający projekt, nie otrzymujesz zapłaty");
                        listOfProjects.remove(selectedProject);
                        System.out.println("Ukończyłeś projekt: " + selectedProject.getTitleOfProject());
                        listOfDoneProjects.add(selectedProject);
                        newDay();
                        choose = true;
                    } else {
                        System.out.println("Oddałeś niedziałający projekt, ale nie tracisz kontraktu (przetestuj kod żeby otrzymać zapłatę) ");
                    }
                } else {
                    if (isChanceHappendWith(selectedProject.getOwnerOfTheProject().getChanceOfLatePaymentByAWeek())) {
                        selectedProject.setDateOfPayment(selectedProject.getDateOfPayment().plusDays(7));
                    }
                    if (isChanceHappendWith(selectedProject.getOwnerOfTheProject().getChanceOfLatePaymentByAMonth())) {
                        selectedProject.setDateOfPayment(selectedProject.getDateOfPayment().plusMonths(1));
                    }
                    if (isChanceHappendWith(selectedProject.getOwnerOfTheProject().getChanceOfNeverGetPaid())) {
                        selectedProject.setDateOfPayment(LocalDate.of(0000, 00, 00));
                    }
                    if (selectedProject.getDateOfPayment().equals(getCurrentDate())) {
                        setMoney(getMoney() + selectedProject.getPriceOfProject());
                    }
                    listOfProjects.remove(selectedProject);
                    System.out.println("Ukończyłeś projekt: " + selectedProject + " \npłatność otrzymasz: " + selectedProject.getDateOfPayment());
                    listOfDoneProjects.add(selectedProject);
                    newDay();
                    choose = true;
                }

            }
        }
    }

    public void addNewWorker() {

        int number;
        boolean choose = false;
        while (choose != true) {
            WorkerMarket market = new WorkerMarket();
            List<Worker> randWork = market.getListOfWorkers();
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

    public void checkVictory() {
        Integer numberOfProjectsMeetingTheRequirements = 0;
        Boolean projectGetBySeller = false;
        for (int i = 0; i < listOfDoneProjects.size(); i++) {
            if (listOfDoneProjects.get(i).getLevelOfComplexity().equals(ProjectComplexity.HIGH) &&
                    !listOfDoneProjects.get(i).getListOfWorkersInProject().contains(owner) &&
                    listOfProjects.get(i).getWasTestedByOwner().equals(false)) {
                if (listOfDoneProjects.get(i).getGetBySeller().equals(true)) {
                    projectGetBySeller = true;
                }
                numberOfProjectsMeetingTheRequirements++;
            }
        }
        if (numberOfProjectsMeetingTheRequirements == 3 && getMoney() > 1000) {
            System.out.println("Wygrałeś");
        }
        //na liście zrobionych projektów 3 mają złożoność high
        //właściciel nie jest na listOfWorkerInProject
        //właściciel nie testował, więc mamy testera
        //jeden projekt znaleziony przez sprzedawce(jakieśoznaczenie na tym projekcie
        // pieniężny stan koncowy wyższy od początkowego 
    }

    public void checkPayment() {
        for (int i = 0; i < listOfDoneProjects.size(); i++) {
            if (listOfDoneProjects.get(i).getDateOfPayment().equals(getCurrentDate())) {
                setMoney(getMoney() + listOfDoneProjects.get(i).getPriceOfProject());
                System.out.println("SUCCESS! Otrzymałeś zapłatę za projekt: " + listOfDoneProjects.get(i).getTitleOfProject() +
                        " w wysokości " + listOfDoneProjects.get(i).getPriceOfProject());
            }
        }
    }

    public void newMonthChecker() {
        if (getCurrentDate().getMonthValue() != 1) {
            if (currentDaysOfBookkeeping < 2) {
                System.out.println("ZUS zamyka twoją firmę! Przegrałeś!");
            }
            Double constantCostOfWorkers = 0.0;
            for (int i = 0; i < listOfWorkers.size(); i++) {
                constantCostOfWorkers += listOfWorkers.get(i).getMaintenanceCost() + listOfWorkers.get(i).getWorkplaceCost();
            }
            setMoney(getMoney() - constantCostOfWorkers);
        }
    }

    private Boolean isChanceHappendWith(int probability) {
        Random rand = new Random();
        return rand.nextInt(100) < probability;
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
                        listOfProjects.get(i).getCurrentDaysOfWork() + "/" + listOfProjects.get(i).getRequiredDaysOfWork() + listOfProjects.get(i).getWasTested());
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

