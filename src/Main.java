import java.util.Scanner;

public class Main {
    public static void register() {

    }

    public static void login() {
    }

    public static void loggedOut() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================\n");
        System.out.println("     HOTEL BOOKING   \n");
        System.out.println("========================\n");

        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("0. Exit");
        System.out.println("========================\n");

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void main(String[] args) {
        loggedOut();}
}