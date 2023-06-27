import java.util.Scanner;
public class Passenger {
    static Scanner scanner = new Scanner(System.in);

    /////////////////// Passenger Menu Options //////////////////////
    static void passengerMenu() {
        System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println("\t" + "\t" + "Passenger Menu Option" + "\t");
        System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println("\t" + "•••••••••••••••" + "Menu Options" + "••••••••••••••••••••••");
        System.out.println("Ⅰ" + '-' + "Change Password");
        System.out.println("Ⅱ" + '-' + "Search flight ticket");
        System.out.println("Ⅲ" + '-' + "Booking ticket");
        System.out.println("Ⅳ" + '-' + "Booked tickets");
        System.out.println("Ⅴ" + '-' + "ticket cancellation");
        System.out.println("Ⅵ"+'-' + "Add charge");
        System.out.println("0" + '-' + "Sign out");

        String option = scanner.nextLine();

        switch (option) {
            case "1":
                Login.changePassword();
                break;
            case "2":
                searchFlights();
                Main.pressEnterToContinue();
                break;
            case "3":
                Tickets.bookingTicket();
                Main.pressEnterToContinue();
                break;
            case "4":
                Tickets.printTickets();
                Main.pressEnterToContinue();
                break;
            case "5":
                Tickets.removeTicket();
                Main.pressEnterToContinue();
                break;
            case "6":
                System.out.println("How much do you want to charge your account ?");
                addCharge();
                Main.pressEnterToContinue();
                break;
            case "0":
                Login.mainMenu();

        }
        passengerMenu();
    }
    /////////////Method for Searching Flights According to Origin or Destination////////////
    public static void searchFlights(){
        System.out.println("Which feature you want to search for ?");
        System.out.println("1-Origin");
        System.out.println("2-Destination");
        String input = scanner.nextLine();
        switch (input){
            case "1":
                System.out.println("Enter your Origin :");
                String origin = scanner.nextLine();
                for (int i = 0; i < Flightschedules.flights.size(); i++) {
                    if(Flightschedules.flights.get(i).getOrigin().equals(origin))
                        System.out.println(Flightschedules.flights.get(i));
                }
                break;
            case "2":
                System.out.println("Enter your Destination");
                String destination = scanner.nextLine();
                for (int i = 0; i < Flightschedules.flights.size(); i++) {
                    if(Flightschedules.flights.get(i).getDestination().equals(destination))
                        System.out.println(Flightschedules.flights.get(i));
                }
                break;
        }
    }
    /////////////// Method for Charging account ////////////////
    public static void addCharge(){
        for (int i = 0; i < Login.users_arr.length; i++) {
            if(Login.users_arr[i].getUsername().equals(Login.input_username)&&
                    Login.users_arr[i].getPassword().equals(Login.input_password)){
                int addCharge = scanner.nextInt();
                Login.users_arr[i].setCharge(addCharge + Login.users_arr[i].getCharge());
                System.out.println("User" + " "+Login.users_arr[i].getUsername()+" "+"charge is :");
                System.out.println(Login.users_arr[i].getCharge());
            }
        }
    }
}
