import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Tickets {
    static Scanner scanner = new Scanner(System.in);
    static Random ticketId = new Random();
    static String inputId;
    static ArrayList<Ticket> boughtTickets = new ArrayList<Ticket>();
    static Ticket[] ticketsArr = new Ticket[boughtTickets.size()];

    ///////////////Method for buying ticket///////////////////////
    public static void bookingTicket() {
        for (int i = 0; i < Flightschedules.flights.size(); i++) {
            System.out.println(Flightschedules.flights.get(i));
        }

        reserveFlight();

        System.out.println("Your ticket has been purchased successfully");

    }
    ////////////////Method for purchased tickets/////////////////
    public static void bookedTickets()
    {
        for (int i = 0; i < Login.users_arr.length; i++)
        {
            if (Login.users_arr[i].getUsername().equals(Login.input_username) &&
                    Login.users_arr[i].getPassword().equals(Login.input_password))
            {
                for (int j = 0; j < Flightschedules.flights.size(); j++) {
                    if (Flightschedules.flights.get(j).getFlightid().equals(inputId)) {
                        Ticket ticket = new Ticket(Login.input_username,
                                Flightschedules.flights.get(j).getFlightid(), Flightschedules.flights.get(j).getOrigin(),


                                Flightschedules.flights.get(j).getDestination(), Flightschedules.flights.get(j).getDate(),
                                Flightschedules.flights.get(j).getTime(), Flightschedules.flights.get(j).getPrice());

                        ticket.setTicketId(ticketId.nextInt(1000, 9999));

                        boughtTickets.add(ticket);
                        ticketsArr = boughtTickets.toArray(ticketsArr);
                        //System.out.println(ticketsArr.length);
                        //System.out.println(boughtTickets.size());
                    }
                }
            }
        }
        //printTickets();
    }
    //////////////////Method for printing purchased tickets////////////
    public static void printTickets(){
        /*for (int i = 0; i < ticketsArr.length; i++) {
            if (ticketsArr[i].getPassengerName().equals(Login.input_username)){
                System.out.println(ticketsArr[i]);}
        }*/
        for (int i = 0 ; i < boughtTickets.size();i++){
            if (boughtTickets.get(i).getPassengerName().equals(Login.input_username)){
                System.out.println(boughtTickets.get(i));
            }
        }
    }
    //////////////////Method for reserving flight ticket////////////////
    public static void reserveFlight(){
        for (int i = 0; i < Login.users_arr.length; i++)
        {
            if (Login.users_arr[i].getUsername().equals(Login.input_username) &&
                    Login.users_arr[i].getPassword().equals(Login.input_password))
            {
                System.out.println("Enter the flightId you want to reserve :");
                inputId = scanner.nextLine();

                for (int j = 0; j < Flightschedules.flights.size(); j++)
                {
                    if(Flightschedules.flights.get(j).getFlightid().equals(inputId))
                    {
                        if (Login.users_arr[i].getCharge() < Flightschedules.flights.get(j).getPrice()) {
                            System.out.println("Please charge your account!");
                            Passenger.passengerMenu();
                        }

                        else if(Flightschedules.flights.get(j).getFlightid().equals(inputId)&&Login.users_arr[i].getCharge()>=
                                Flightschedules.flights.get(j).getPrice())
                        {
                            Flightschedules.flights.get(j).setSeats(Flightschedules.flights.get(j).getSeats()-1);
                            Login.users_arr[i].setCharge(Login.users_arr[i].getCharge()-Flightschedules.flights.get(j).getPrice());
                            Tickets.bookedTickets();
                        }

                    }
                }
            }
        }
    }
    //////////////////Method for removing tickets////////////////////////
    public static void removeTicket(){
        for (int i = 0; i < Login.users.size(); i++) {
            if(Login.users.get(i).getUsername().equals(Login.input_username)&&
                    Login.users.get(i).getPassword().equals(Login.input_password))
            {
                System.out.println("Enter your ticketID :");
                String ticketId = scanner.nextLine();
                int ticketID = Integer.parseInt(ticketId);
                for (int j = 0; j < boughtTickets.size(); j++) {
                    if(ticketID==boughtTickets.get(j).getTicketId())
                    {
                        Login.users_arr[i].setCharge(Login.users_arr[i].getCharge()+boughtTickets.get(j).getPrice());
                        for (int k = 0; k < Flightschedules.flights.size(); k++) {
                            if (Flightschedules.flights.get(k).getFlightid().equals(boughtTickets.get(j).getFlightId())){
                                int currentSeat = Flightschedules.flights.get(k).getSeats();
                                int newSeat = currentSeat + 1;
                                Flightschedules.flights.get(k).setSeats(newSeat);
                            }
                        }
                        boughtTickets.remove(j);
                    }
                }
            }
        }
    }
}
