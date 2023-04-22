import java.util.Scanner;

public class Admin {
    static Scanner scanner = new Scanner(System.in);

    static void adminMenu() {
        System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println("\t" + "•••••••••••••••" + "Admin Menu Options" + "••••••••••••••••••••••");
        System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println("Ⅰ" + '-' + "Add");
        System.out.println("Ⅱ" + '-' + "Update");
        System.out.println("Ⅲ" + '-' + "Remove");
        System.out.println("Ⅳ" + '-' + "Flight Schedules");
        System.out.println("0" + '-' + "Sign Out");



        String option = scanner.nextLine();

        switch (option) {
            case "1":

                break;
            case "2":

                break;
            case "3":

            case "4":

            case "0":
                Login.mainMenu();
            default:
                System.out.println("Invalid option.");

        }
    }
}
