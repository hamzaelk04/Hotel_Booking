package View;

import java.util.Scanner;

public class MenuView {
    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================\n");
        System.out.println("     HOTEL BOOKING   \n");
        System.out.println("========================\n");

        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("0. Exit");
        System.out.println("========================\n");


    }
}
