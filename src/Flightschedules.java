import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Flightschedules {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Flight> flights = new ArrayList<Flight>();

    //static Iterator<Flight> flightList = flights.iterator();
    public static Flight[] flights_arr = new Flight[50];

    static int seats;

    ////////////// Method for adding default flights //////////////////
    public void add_default_flights() {
        Flight flight1 = new Flight("wx-12", "yazd", "tehran","1401-12-10","12:30",700000,51);

        Flight flight2 = new Flight("wz-15", "mashhad", "ahvaz","1401-12-11","08:00",900000,245);

        Flight flight3 = new Flight("bg-22", "shiraz", "tabriz","1401-12-12","10:30",1100000,12);

        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);

    }
    //////////////// Method for adding admin flights /////////////////
    public void addFlight(){
        System.out.println("Enter your flightId : ");
        String id = input.nextLine();
        System.out.println("Enter your origin : ");
        String origin = input.nextLine();
        System.out.println("Enter your destination : ");
        String destination = input.nextLine();
        System.out.println("Enter your date : ");
        String date = input.nextLine();
        System.out.println("Enter your time : ");
        String time = input.nextLine();
        System.out.println("Enter your price :");
        String prices = input.nextLine();
        int price = Integer.parseInt(prices);
        System.out.println("Enter your seats :");
        String seat = input.nextLine();
        seats = Integer.parseInt(seat);

        if (origin.equals(destination)){
            System.out.println("Same origin and destination ?!");
            System.out.println("Not possible");
            Main.pressEnterToContinue();
            addFlight();
        }

        Flight flight = new Flight(id,origin,destination,date,time,price,seats);
        flights.add(flight);
        System.out.println("Flight has been added successfully");

        Main.pressEnterToContinue();
        Admin.adminMenu();
    }
    /////////// Method for editing the features of a flight /////////////
    public void update(){
        System.out.println("Enter the flight-id you want to update :");
        String ID = input.nextLine();
        flights_arr = flights.toArray(flights_arr);
        for (int i = 0; i < flights.size(); i++) {
            if(flights.get(i).getFlightid().equals(ID)){
                System.out.println("Which feature you want to change ? ");
                System.out.println("1-Origin");
                System.out.println("2-Destination");
                System.out.println("3-Date");
                System.out.println("4-Time");
                System.out.println("5-Price");
                System.out.println("6-Seats");
                String update = input.nextLine();
                switch (update){
                    case "1" :
                        System.out.println("Enter your new Origin :");
                        String newOrigin = input.nextLine();
                        flights.get(i).setOrigin(newOrigin);
                        break;
                    case "2" :
                        System.out.println("Enter your new Destination :");
                        String newDestination = input.nextLine();
                        flights.get(i).setDestination(newDestination);
                        break;
                    case "3" :
                        System.out.println("Enter your new Date :");
                        String newDate = input.nextLine();
                        flights.get(i).setDate(newDate);
                        break;
                    case "4" :
                        System.out.println("Enter your new Time : ");
                        String newTime = input.nextLine();
                        flights.get(i).setTime(newTime);
                        break;
                    case "5" :
                        System.out.println("Enter your new Price : ");
                        String newPrice = input.nextLine();
                        flights.get(i).setPrice(Integer.parseInt(newPrice));
                        break;
                    case "6" :
                        System.out.println("Enter your new Seats : ");
                        String newSeats = input.nextLine();
                        flights.get(i).setSeats(Integer.parseInt(newSeats));
                        break;
                    default:
                        System.out.println("Wrong chosen option");
                        update();
                }
            }
        }
        Main.pressEnterToContinue();
        Admin.adminMenu();
    }
    //////////////// Method for printing remove flight ///////////////
    public void remove() {
        System.out.println("Enter the flight-id you want to remove ?");
        String ID = input.nextLine();

        if(ID.equals("wx-12")||ID.equals("wz-15")||ID.equals("bg-22"))
        {
            System.out.println("You can't remove default flights");
            Main.pressEnterToContinue();
            Admin.adminMenu();
        }

        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getFlightid().equals(ID)) {
                flights.remove(i);
            }
        }

        Main.pressEnterToContinue();
        Admin.adminMenu();
    }
    //////////// Method for printing flight schedules ///////////
    public void displayFlights() {
        for (int i = 0; i < flights.size(); i++) {
            System.out.println(flights.get(i));
        }
        Main.pressEnterToContinue();
        Admin.adminMenu();
    }
}
