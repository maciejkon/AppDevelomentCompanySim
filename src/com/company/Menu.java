package com.company;

import java.util.Scanner;

public class Menu {
    static Scanner in = new Scanner( System.in );

    static void opcjaPierwsza()
    {
        System.out.println( "Wybrano opcję pierwszą" );
    }

    static void opcjaDruga()
    {
        System.out.println( "Wybrano opcję drugą" );
    }

    static void pokazMenu()
    {
        System.out.print( "Wybierz opcje:\n1. Pierwsza\n2. Druga\n3. Koniec\n>> " );
    }

    static void menu()
    {
        int number;
        do
        {
            pokazMenu();
            number = in.nextInt();
            switch( number )
            {
                case 1 : opcjaPierwsza();
                    break;
                case 2 : opcjaDruga();
                    break;
            }
        }
        while( number != 3 );
    }
}
