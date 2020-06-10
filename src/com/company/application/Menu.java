package com.company.application;

import java.util.Scanner;

public class Menu {

    public int menu() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Nowy projekt");
        System.out.println("     2. Szukaj Klientów");
        System.out.println("     3. Pracuj nad projektem");
        System.out.println("     4. Testuj kod");
        System.out.println("     5. Oddaj gotowy projekt");
        System.out.println("     6. Zatrudnij nowego pracownika");
        System.out.println("     7. Zwolnij pracownika");
        System.out.println("     8. Rozlicz się");
        System.out.println("     0. Koniec");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();

        return w;
    }

}

