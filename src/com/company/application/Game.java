package com.company.application;

import com.company.business.People.Worker.Player;
import com.company.business.company.Company;

import java.io.IOException;
import java.util.Scanner;

public class Game {

    private Player player;
    private Company company;

    public Game() {
        this.player = addNewPlayer();
        this.company = new Company(this.player);
    }

    public Player addNewPlayer() {
        String name;
        String surname;
        Scanner in = new Scanner(System.in);
        System.out.println("Stwórz nowego gracza: ");
        System.out.println("Podaj imię: ");
        name = in.nextLine();
        System.out.println("Podaj nazwisko: ");
        surname = in.nextLine();
        return new Player(name, surname);
    }

    public void startGame() throws IOException {
        Menu menuObject = new Menu();

        company.showWelcomeInfo();
        company.addNewProject();
        Scanner in = new Scanner(System.in);

        company.showActualInfo();
        int number = menuObject.menu();

        while (number != 0) {

            switch (number) {
                case 1:
                    company.addNewProject();
                    company.newDay();
                    break;
                case 2:
                    company.newDay();

                    break;
                case 3:
                    company.workOnProjects();
                    company.newDay();

                    break;
                case 4:
                    company.newDay();

                    break;
                case 5:
                    company.finishProject();
                    company.newDay();

                    break;
                case 6:
                    company.addNewWorker();
                    company.newDay();

                    break;
                case 7:
                    company.fireWorker();
                    company.newDay();

                    break;
                case 8:
                    company.newDay();
                    break;
            }

            company.showActualInfo();

            number = menuObject.menu();
        }
        System.out.println("     ****************************************");
        System.out.println("\n     Koniec programu\n\n");
    }


}
