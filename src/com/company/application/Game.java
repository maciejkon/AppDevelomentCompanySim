package com.company.application;

import com.company.business.People.Customer.HighClassCustomer;
import com.company.business.People.Customer.LowClassCustomer;
import com.company.business.People.Customer.MiddleClassCustomer;
import com.company.business.People.Worker.Player;
import com.company.business.company.Company;

import java.io.IOException;
import java.util.Scanner;

public class Game {

    private HighClassCustomer HCC;
    private MiddleClassCustomer MCC;
    private LowClassCustomer LCC;
    private Player player;
    private Company company;

    public Game() {
        this.HCC = new HighClassCustomer("Janek", "Kowalski", 100.0, "Janek@gmail.com");
        this.MCC = new MiddleClassCustomer("Jan", "Kowalski", 200.0, "Jakiśtam@gmail.com");
        this.LCC = new LowClassCustomer("Zbigniew", "Kulesza", 50.0, "brak");
        this.player = new Player("Maciej", "Weltrowski", 10.0, "maciejweltrowski@gmail.com");
        this.company = new Company(this.player);
    }

    public void startGame() throws IOException {

        System.out.println();
        System.out.println("**************************************");
        System.out.println("*               APPSTORE             *");
        System.out.println("**************************************");
        System.out.println("Witaj: " + this.player.getName() + " " + this.player.getSurname());
        company.addNewProject();
        Menu menuObject = new Menu();
        Scanner in = new Scanner(System.in);

        int number = menuObject.menu();
        while (number != 0) {
            switch (number) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:


            }

            System.out.println("\nWciśnij Enter, aby kontynuować...");
            System.in.read();

            number = menuObject.menu();
        }
        System.out.println("     ****************************************");
        System.out.println("\n     Koniec programu\n\n");
    }
}
