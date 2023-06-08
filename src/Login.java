import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Login {
    static ArrayList<User> users = new ArrayList<User>();
    static User[] users_arr = new User[users.size()];
    static Scanner scanner = new Scanner(System.in);
    static String input_username;
    static String input_password;
    //////////////Main Menu///////////////////
    public static void mainMenu() {
        System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println("\t" + "\t" + "Welcome To Airline Reservation System" + "\t");
        System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println("\t" + "•••••••••••••••" + "Menu Options" + "••••••••••••••••••••••");
        System.out.println("Ⅰ" + '-' + "Sign Up");
        System.out.println("Ⅱ" + '-' + "Sign In");
        System.out.println("Ⅲ" + '-' + "Exit");

        int option = scanner.nextInt();

        scanner.nextLine();

        switch (option) {
            case 1:
                signUp(scanner);
                break;
            case 2:
                logIn(scanner);
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid option.");
        }
    }

    //////////// Method for Sign Up ///////////////
    static void signUp(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        users.add(new User(username,password));

        System.out.println("User " + username + " registered successfully.");
        System.out.println();
        System.out.println("Back to Main Menu ? ");
        System.out.println("1-Yes");
        System.out.println("2-No");

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                mainMenu();
                break;
            case 2:
                System.exit(0);
        }
    }

    /////////Method for checking correct username & password////////
    static public boolean checkLogin(String username,String password){
        users_arr = users.toArray(users_arr);
        for(int i=0 ; i<users_arr.length ; i++){
            if(users_arr[i].getUsername().equals(username)&&
                    users_arr[i].getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    ////////////// Method for Sign in ///////////////
    static void logIn(Scanner scanner) {
        System.out.print("Enter username: ");
        Login.input_username = scanner.nextLine();
        System.out.print("Enter password: ");
        Login.input_password = scanner.nextLine();

        if (input_username.equals("ehsan")&&input_password.equals("1381")){
            System.out.println("Welcome Admin");
            System.out.println();
            Admin.adminMenu();
        }

        if(checkLogin(input_username,input_password)){
            System.out.println("User"+" "+input_username+" "+"login successfully");
            Passenger.passengerMenu();
        }

        if(!checkLogin(input_username,input_password)){
            System.out.println("Invalid username or password");
            Main.pressEnterToContinue();
            mainMenu();
        }
    }
    ///////////////// Method for Changing Password ///////////////
    public static void changePassword(){
        System.out.println("Enter your current password :");
        String old_password = scanner.nextLine();
        System.out.println("Enter your new Password");
        String new_password = scanner.nextLine();
        for (int i = 0; i < users_arr.length; i++) {
            if(users_arr[i].getPassword().equals(old_password)){
                users_arr[i].setPassword(new_password);
                System.out.println("Password has been changed");
                Main.pressEnterToContinue();
                Login.mainMenu();
            }
        }
    }
}

