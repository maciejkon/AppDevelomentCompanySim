package com.company.application;

import com.company.business.People.Worker.Player;
import com.company.business.company.Company;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Game {

    public static LocalDate now;
    private Player player;
    private Company company;

    public Game() {
        this.now = LocalDate.now();
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

        System.out.println();
        System.out.println("**************************************");
        System.out.println("*               APPSTORE             *");
        System.out.println("**************************************");
        System.out.println("Witaj: " + this.player.getName() + " " + this.player.getSurname() + this.player.getMoney());
        System.out.println("Twoje umiejętności to: " + this.player.getListOfTechnology());
        System.out.println("Wybierz projekt początkowy!\n------------------");
        company.addNewProject();
        Scanner in = new Scanner(System.in);

        int number = menuObject.menu();
        while (number != 0) {
            switch (number) {
                case 1:
                    company.addNewProject();

                    break;
                case 2:
                    break;
                case 3:
                    company.workOnProjects();
                    break;
                case 4:
                    break;
                case 5:
                    company.finishProject();
                    break;
                case 6:
                    company.addNewWorker();
                    break;
                case 7:
                    company.fireWorker();
                    break;
                case 8:
                    break;

            }

            System.out.println("\nWciśnij Enter, aby kontynuować...");
            System.in.read();

            number = menuObject.menu();
        }
        System.out.println("     ****************************************");
        System.out.println("\n     Koniec programu\n\n");
    }

    public LocalDate getNow() {
        return now;
    }

    public void setNow(LocalDate now) {
        this.now = now;
    }
}
